package com.ecommerce.inventory.service;

import java.util.List;

import com.ecommerce.inventory.viewModel.product.ProductGetDetailVm;
import com.ecommerce.inventory.viewModel.product.ProductPostVm;

public interface ProductService {
    ProductGetDetailVm createProduct(ProductPostVm productPostVm);

    ProductGetDetailVm findProductById(Integer id);

    List<ProductGetDetailVm> findProductsByShopId(Integer shopId);
}