package com.ecommerce.product.service.impl;

import com.ecommerce.commonlib.exception.NotFoundException;
import com.ecommerce.product.model.Category;
import com.ecommerce.product.repository.CategoryRepository;
import com.ecommerce.product.service.CategoryService;
import com.ecommerce.product.utils.Constants;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(int id, Category category) {
        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Constants.ErrorCode.NOT_FOUND_CATEGORY, id));

        existing.setCategoryName(category.getCategoryName());
        existing.setParent(category.getParent());
        return categoryRepository.save(existing);
    }

    @Override
    public void delete(int id) {
        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Constants.ErrorCode.NOT_FOUND_CATEGORY, id));

        categoryRepository.delete(existing);
    }

    @Override
    public Category getById(int id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Constants.ErrorCode.NOT_FOUND_CATEGORY, id));
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

}
