package com.ecommerce.inventory.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.commonlib.exception.NotFoundException;
import com.ecommerce.inventory.model.Product;
import com.ecommerce.inventory.repository.ProductRepository;
import com.ecommerce.inventory.service.ProductService;
import com.ecommerce.inventory.utils.Constants;
import com.ecommerce.inventory.viewModel.product.ProductGetDetailVm;
import com.ecommerce.inventory.viewModel.product.ProductPostVm;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductGetDetailVm createProduct(ProductPostVm productPostVm) {
        Product saved = productRepository.save(productPostVm.toEntity());
        return saved.toProductGetDetailVm();
    }

    @Override
    public ProductGetDetailVm findProductById(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Constants.ErrorCode.NOT_FOUND_PRODUCT, id));
        return product.toProductGetDetailVm();
    }

    @Override
    public List<ProductGetDetailVm> findProductsByShopId(Integer shopId) {
        List<Product> products = productRepository.findByShopId(shopId);
        return products.stream()
                .map(Product::toProductGetDetailVm)
                .toList();
    }

}
