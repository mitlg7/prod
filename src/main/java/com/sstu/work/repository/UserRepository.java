package com.sstu.work.repository;

import com.sstu.work.model.Role;
import com.sstu.work.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    final JdbcTemplate jdbc;

    RowMapper<User> mapper = (rs, rowNum) -> new User().setId(rs.getInt("id"))
            .setLogin(rs.getString("login"))
            .setEmail(rs.getString("email"))
            .setRole(new Role().setType(rs.getString("role")));

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
}
