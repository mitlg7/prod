package com.sstu.work.service;

import com.sstu.work.model.Category;
import com.sstu.work.model.Product;
import com.sstu.work.model.utils.ProductRequest;

import java.util.List;


public interface ProductService {
    Product getProductById(String id);

    List<Product> getAllProducts();
    List<Product> searchProducts(String search);

    List<Product> getProductsByType(Category category);
    List<Product> getProductsByUserId(Long id);

    void createProduct(String login, ProductRequest productRequest);



    boolean removeById(String id);

}
