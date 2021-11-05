package com.sstu.work.service;

import com.sstu.work.model.Category;
import com.sstu.work.model.Product;

import java.util.List;


public interface ProductService {
    Product getProductById(String id);

    List<Product> getAllProducts();

    List<Product> getProductsByType(Category category);

    Product createProduct(Product product);

    boolean removeById(String id);

}
