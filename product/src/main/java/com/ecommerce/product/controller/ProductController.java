package com.ecommerce.product.controller;

import com.ecommerce.commonlib.constants.ApiConstant;
import com.ecommerce.product.service.ProductService;
import com.ecommerce.product.viewModel.product.ProductGetDetailVm;
import com.ecommerce.product.viewModel.product.ProductPostVm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiConstant.PRODUCTS_URL)
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductGetDetailVm> createProduct(@RequestBody ProductPostVm productPostVm) {
        ProductGetDetailVm createdProduct = productService.createProduct(productPostVm);
        return ResponseEntity.ok(createdProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductGetDetailVm> getProductById(@PathVariable Integer id) {
        ProductGetDetailVm product = productService.findProductById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/shop/{shopId}")
    public ResponseEntity<List<ProductGetDetailVm>> getProductsByShopId(@PathVariable Integer shopId) {
        List<ProductGetDetailVm> products = productService.findProductsByShopId(shopId);
        return ResponseEntity.ok(products);
    }
}