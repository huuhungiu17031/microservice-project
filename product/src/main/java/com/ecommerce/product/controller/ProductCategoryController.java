package com.ecommerce.product.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.commonlib.constants.ApiConstant;
import com.ecommerce.product.model.ProductCategory;
import com.ecommerce.product.model.key.ProductCategoryId;
import com.ecommerce.product.service.ProductCategoryService;

@RestController
@RequestMapping(ApiConstant.PRODUCT_CATEGORY_URL)
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping("/{productId}/{categoryId}")
    public ResponseEntity<ProductCategory> getById(@PathVariable int productId, @PathVariable int categoryId) {
        ProductCategoryId id = new ProductCategoryId(productId, categoryId);
        ProductCategory found = productCategoryService.getById(id);
        return ResponseEntity.ok(found);
    }

    @PostMapping
    public ProductCategory create(@RequestBody ProductCategory productCategory) {
        return productCategoryService.save(productCategory);
    }

    @PutMapping("/{productId}/{categoryId}")
    public ProductCategory updateProductCategory(
            @PathVariable int productId,
            @PathVariable int categoryId,
            @RequestBody ProductCategory updatedData) {

        ProductCategoryId id = new ProductCategoryId(productId, categoryId);
        return productCategoryService.update(id, updatedData);
    }
}
