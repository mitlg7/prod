package com.sstu.work.repository;

import com.sstu.work.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    final JdbcTemplate jdbc;

    RowMapper<Product> mapper = (rs, rowNum) -> new Product()
            .setId(rs.getLong("id"))
            .setName(rs.getString("name"))
            .setImage(rs.getString("image"))
            .setDate(rs.getDate("date"))
            .setDescription(rs.getString("description"))
            .setCountry(rs.getString("description"))
            .setPrice(rs.getLong("price"));

    public ProductRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Product> getProductsByUserId(Long user_id) {
        return jdbc.query("call productByUserId(?)", mapper, user_id);
    }

//    public List<Product> getProductByCategory(String type) {
//        String sql = "select * from product where category_id = (" +
//                "select id from category where type =" + type + ")";
//
//        return jdbc.query(sql, mapper);
//    }

    public void createProduct(Product product) {
        jdbc.update("call createProduct(?,?,?,?,?,?,?,?)",
                product.getUserId().intValue(),
                product.getImage(),
                product.getName(),
                product.getDescription(),
                product.getPrice().intValue(),
                product.getDate(),
                product.getCategory().getId(),
                product.getCountry().getId());
    }

    public List<Product> getAll() {
        return jdbc.query("call allProduct()", mapper);
    }

}
