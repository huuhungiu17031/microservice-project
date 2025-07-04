package com.ecommerce.product.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce.commonlib.exception.NotFoundException;
import com.ecommerce.product.model.ProductCategory;
import com.ecommerce.product.model.key.ProductCategoryId;
import com.ecommerce.product.repository.ProductCategoryRepository;
import com.ecommerce.product.service.ProductCategoryService;
import com.ecommerce.product.utils.Constants;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private ProductCategoryRepository productCategoryRepository;

    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public ProductCategory getById(ProductCategoryId id) {
        return productCategoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        Constants.ErrorCode.CATEGORY_AND_PRODUCT_NOT_FOUND,
                        id.getCategoryId(),
                        id.getProductId()));
    }

    @Override
    public ProductCategory update(ProductCategoryId id, ProductCategory updatedData) {
        Optional<ProductCategory> existingOpt = productCategoryRepository.findById(id);
        if (!existingOpt.isPresent())
            throw new NotFoundException(Constants.ErrorCode.CATEGORY_AND_PRODUCT_NOT_FOUND, id.getCategoryId(),
                    id.getProductId());
        ProductCategory existing = existingOpt.get();
        if (updatedData.getCategory() != null)
            existing.setCategoryId(updatedData.getCategoryId());
        if (updatedData.getProduct() != null)
            existing.setProductId(updatedData.getProductId());
        return productCategoryRepository.save(existing);
    }

}
