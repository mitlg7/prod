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

    public Long create(UserInfo userInfo) {
        List<Long> id = jdbc.query("select * from create_user_info(?,?,?,?,?) as id", mapperId,
                userInfo.getName(),
                userInfo.getLastName(),
                userInfo.getPhone(),
                userInfo.getImage(),
                userInfo.getBirthday()
        );
        return id.get(0);
    }


    public UserInfo getById(Long id) {
        if (id == null)
            return null;
        var userInfo = jdbc.query("select * from user_info_by_id(?)", mapper, id);
        if (userInfo.isEmpty())
            throw new NotFoundException("UserInfo with id " + id + " not found");
        return userInfo.get(0);
    }

}
