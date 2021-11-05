package com.sstu.work.service;

import com.sstu.work.model.Category;
import com.sstu.work.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements  ProductService{
    @Override
    public Product getProductById(String id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public List<Product> getProductsByType(Category category) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }
}
