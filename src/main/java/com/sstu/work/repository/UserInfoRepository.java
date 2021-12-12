package com.sstu.work.repository;

import com.sstu.work.model.UserInfo;
import com.sstu.work.model.utils.NotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserInfoRepository {

    final JdbcTemplate jdbc;

    RowMapper<UserInfo> mapper = (rs, rowNum) -> new UserInfo()
            .setId(rs.getLong("id"))
            .setName(rs.getString("name"))
            .setLastName(rs.getString("lastname"))
            .setBirthday(rs.getDate("birthday"))
            .setPhone(rs.getString("phone"))
            .setImage(rs.getString("image"));

    RowMapper<Long> mapperId = (rs, rowNum) -> rs.getLong("id");

    public UserInfoRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void create(UserInfo userInfo) {
        jdbc.update("call createUserInfo(?,?,?,?,?)",
                userInfo.getName(),
                userInfo.getLastName(),
                userInfo.getPhone(),
                userInfo.getImage(),
                userInfo.getBirthday()
        );
    }


    public UserInfo getById(Long id) {
        if (id == null)
            return null;
        var userInfo = jdbc.query("call userInfoById(?)", mapper, id);
        if (userInfo.isEmpty())
            return null;
        return userInfo.get(0);
    }

}
