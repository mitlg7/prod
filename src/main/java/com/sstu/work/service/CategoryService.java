package com.sstu.work.service;

import com.sstu.work.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category get(int id);
}
