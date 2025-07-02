package com.ecommerce.product.model;

import com.ecommerce.commonlib.model.BaseEntity;
import com.ecommerce.product.viewModel.product.ProductGetDetailVm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "products")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productName;
    private String description;
    private Integer price;
    private Integer shopId;
    @Column(name = "is_published", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isPublished;

    public ProductGetDetailVm toProductGetDetailVm() {
        return new ProductGetDetailVm(id, productName, description, price, shopId);
    }
}
