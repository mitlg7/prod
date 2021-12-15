package com.sstu.work.repository;

import com.sstu.work.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    UserRepository userRepository;

    final JdbcTemplate jdbc;

    RowMapper<Product> mapper = (rs, rowNum) -> new Product()
            .setId(rs.getLong("id"))
            .setName(rs.getString("name"))
            .setImage(rs.getString("image"))
            .setDate(rs.getDate("date"))
            .setDescription(rs.getString("description"))
            .setUserId(rs.getLong("user_id"))
            .setCountry(countryRepository.getById(rs.getInt("country_id")))
            .setCategory(categoryRepository.get(rs.getInt("category_id")))
            .setPrice(rs.getLong("price"));

    public ProductRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Product> getProductsByUserId(Long user_id) {
        return jdbc.query("call productByUserId(?)", mapper, user_id);
    }
    public Product get(Long id) {
        return jdbc.query("call productById(?)", mapper, id).get(0);
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

    public void removeProduct(Long id){
        jdbc.update("call removeProduct(?)",
                id);
    }

    public List<Product> getAll() {
        return jdbc.query("call allProduct()", mapper);
    }

    public List<Product> search(String search){
        return jdbc.query("call searchProducts(?)", mapper, search);
    }

}
