package com.ecommerce.inventory.model;

import com.ecommerce.inventory.viewModel.product.ProductGetDetailVm;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productName;
    private String description;
    private Integer price;
    private Integer shopId;

    public ProductGetDetailVm toProductGetDetailVm() {
        return new ProductGetDetailVm(id, productName, description, price, shopId);
    }
}
