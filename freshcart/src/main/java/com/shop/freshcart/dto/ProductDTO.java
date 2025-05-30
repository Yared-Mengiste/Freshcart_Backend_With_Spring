package com.shop.freshcart.dto;

import com.shop.freshcart.entities.Product_category;
import com.shop.freshcart.entities.Products;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class ProductDTO {

    @NotBlank(message = "Product name cannot be blank")
    private String name;

    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    private Double price;

    @NotBlank(message = "Image URL cannot be blank")
    private String img;

    @NotNull(message = "Category ID must be provided")
    @Min(value = 1, message = "Category ID must be a positive number")
    private Long categoryId;

    private String categoryName;

    @Min(value = 0, message = "Stock cannot be negative")
    private Integer stock;

    public ProductDTO(Products product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.img = product.getImg();
        this.categoryId = product.getCategory() != null ? product.getCategory().getId() : null;
        this.categoryName = product.getCategory() != null ? product.getCategory().getName() : null;
        this.stock = product.getStock();
    }


}
