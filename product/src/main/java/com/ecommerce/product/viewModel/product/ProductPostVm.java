package com.ecommerce.product.viewModel.product;

import com.ecommerce.product.model.Product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductPostVm(
        @NotBlank String productName,
        String description,
        @NotNull @Min(0) Integer price,
        @NotNull Integer shopId) {
    public Product toEntity() {
        Product product = new Product();
        product.setProductName(productName);
        product.setDescription(description);
        product.setPrice(price);
        product.setShopId(shopId);
        return product;
    }

}