package com.ecommerce.product.service;

import com.ecommerce.product.model.ProductCategory;
import com.ecommerce.product.model.key.ProductCategoryId;

public interface ProductCategoryService {
    ProductCategory save(ProductCategory productCategory);

    ProductCategory getById(ProductCategoryId id);

    ProductCategory update(ProductCategoryId id, ProductCategory updatedData);
}