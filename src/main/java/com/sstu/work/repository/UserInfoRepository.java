package com.sstu.work.repository;

import com.sstu.work.model.User;
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
            .setBirthday(rs.getDate("date"))
            .setPhone(rs.getString("phone"))
            .setImage(rs.getString("image"));

    public UserInfoRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void create(UserInfo userInfo){
        //todo
    }

    public UserInfo getById(Long id) {
        var userInfo = jdbc.query("select * from user_info_by_id(?)", mapper, id);
        if (userInfo.isEmpty())
            throw new NotFoundException("UserInfo with id " + id + " not found");
        return userInfo.get(0);
    }

}
