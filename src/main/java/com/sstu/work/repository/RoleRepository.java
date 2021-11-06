package com.sstu.work.repository;

import com.sstu.work.model.Role;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepository {
    final JdbcTemplate jdbc;

    RowMapper<Role> mapper = (rs, rowNum) -> new Role()
            .setId(rs.getLong("id"))
            .setType(rs.getString("type"));

    public RoleRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Role getByType(String type){
        return jdbc.query("select * from ROLE_BY_TYPE(?)", mapper, type ).get(0);
    }

    public Role getById(Long id){
        return jdbc.query("select * from ROLE_BY_ID(?)", mapper, id ).get(0);
    }
}
