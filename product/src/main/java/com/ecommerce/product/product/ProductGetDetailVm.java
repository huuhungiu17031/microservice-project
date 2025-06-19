package com.ecommerce.product.product;

public record ProductGetDetailVm(
        Integer id,
        String productName,
        String description,
        Integer price,
        Integer shopId
) { }
