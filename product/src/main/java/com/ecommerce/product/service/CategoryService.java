package com.ecommerce.product.service;

import java.util.List;

import com.ecommerce.product.model.Category;

public interface CategoryService {
    Category create(Category category);

    Category update(int id, Category category);

    void delete(int id);

    Category getById(int id);

    List<Category> getAll();
}