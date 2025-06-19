package com.ecommerce.product.service;

import com.ecommerce.product.viewModel.product.ProductGetDetailVm;
import com.ecommerce.product.viewModel.product.ProductPostVm;

import java.util.List;

public interface ProductService {
    ProductGetDetailVm createProduct(ProductPostVm productPostVm);

    ProductGetDetailVm findProductById(Integer id);

    List<ProductGetDetailVm> findProductsByShopId(Integer shopId);
}