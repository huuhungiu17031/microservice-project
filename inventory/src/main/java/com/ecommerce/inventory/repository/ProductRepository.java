package com.ecommerce.inventory.repository;

import com.ecommerce.inventory.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByShopId(Integer shopId);
}
