package com.sstu.work.repository;


import com.sstu.work.model.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository {

    final JdbcTemplate jdbc;
    RowMapper<Category> mapper = (rs, rowNum) -> new Category()
            .setId(rs.getLong("id"))
            .setType(rs.getString("type"));

    public CategoryRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Category> allCategories() {
        return jdbc.query("call allCategory()", mapper);
    }

    public void addCategory(String type) {
        jdbc.update("call createCategory(?)", type);
    }

    public void removeCategory(String id) {
        jdbc.update("call removeCategory(?)", id);
    }

}
