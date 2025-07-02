package com.ecommerce.product.service.impl;

import com.ecommerce.commonlib.exception.NotFoundException;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.repository.ProductRepository;
import com.ecommerce.product.service.ProductService;
import com.ecommerce.product.utils.Constants;
import com.ecommerce.product.viewModel.product.ProductGetDetailVm;
import com.ecommerce.product.viewModel.product.ProductPostVm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductGetDetailVm create(ProductPostVm productPostVm) {
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
