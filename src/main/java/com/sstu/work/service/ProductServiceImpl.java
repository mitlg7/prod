package com.sstu.work.service;

import com.sstu.work.model.Category;
import com.sstu.work.model.Product;
import com.sstu.work.model.User;
import com.sstu.work.model.utils.ProductRequest;
import com.sstu.work.repository.ProductRepository;
import com.sstu.work.service.utils.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements  ProductService{

    @Autowired
    ImageService imageService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserService userService;

    @Override
    public Product getProductById(String id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAll();
    }

    @Override
    public List<Product> getProductsByType(Category category) {
        return null;
    }

    @Override
    public void createProduct(String login, ProductRequest productRequest) {
        User user = userService.getUserByUsername(login);
        Date utilDate = new Date();
        Product product = new Product()
                .setName(productRequest.getName())
                .setDescription(productRequest.getDescription())
                .setPrice(Long.valueOf(productRequest.getPrice()))
                .setImage(imageService.saveImage(productRequest.getImage()))
                .setUserId(user.getId())
                .setDate(new java.sql.Date(utilDate.getTime()));

        productRepository.createProduct(product);

    }




    @Override
    public boolean removeById(String id) {
        return false;
    }
}
