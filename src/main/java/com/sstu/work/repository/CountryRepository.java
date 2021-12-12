package com.sstu.work.repository;

import com.sstu.work.model.Country;
import com.sstu.work.model.Role;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepository {

    final JdbcTemplate jdbc;

    RowMapper<Country> mapper = (rs, rowNum) -> new Country()
            .setId(rs.getLong("id"))
            .setName(rs.getString("name"));

    public CountryRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    public Country getById(int id){
        return jdbc.query("call countryById(?)" , mapper, id).get(0);
    }
    public List<Country> getAll(){
        return jdbc.query("call allCountry()", mapper);
    }
}
