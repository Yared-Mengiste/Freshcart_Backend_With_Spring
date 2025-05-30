package com.shop.freshcart.dto;

import com.shop.freshcart.entities.Products;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class ProductResponseDTO {
    private Long id;  // Include the ID in the response

    private String name;
    private Double price;
    private String img;
    private Long categoryId;  // Category ID to return in response
    private String categoryName;
    private Integer stock;

    // Constructor for converting from Product entity
    public ProductResponseDTO(Products product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.img = product.getImg();
        this.categoryId = product.getCategory() != null ? product.getCategory().getId() : null;
        this.categoryName = product.getCategory() != null ? product.getCategory().getName() : null;  // Map categoryName
        this.stock = product.getStock();
    }
}
