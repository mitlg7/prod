package com.sstu.work.service;

import com.sstu.work.model.Product;
import com.sstu.work.model.ProductType;

import java.util.List;

public interface ProductService {
    Product getProductById(String id);
    List<Product> getAllProducts();
    List<Product> getProductsByType(ProductType productType);
    Product createProduct(Product product);
    boolean removeById(String id);

}
