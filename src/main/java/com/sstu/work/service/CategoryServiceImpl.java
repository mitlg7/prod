package com.sstu.work.service;

import com.sstu.work.model.Category;
import com.sstu.work.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.allCategories();
    }

    @Override
    public Category get(int id) {
        return null;
    }
}
