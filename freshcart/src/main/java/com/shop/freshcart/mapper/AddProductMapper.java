package com.shop.freshcart.mapper;


import com.shop.freshcart.dto.ProductDTO;
import com.shop.freshcart.dto.ProductResponseDTO;
import com.shop.freshcart.entities.Product_category;
import com.shop.freshcart.entities.Products;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddProductMapper {

//    ProductDTO toDto(Products products);

//    @Mapping(source = "categoryId", target = "category")
//    Products toEntity(ProductDTO dto);
//
//    // Custom mapping from Long to Product_category
//    default Product_category map(Long categoryId) {
//        if (categoryId == null) {
//            return null;
//        }
//        Product_category category = new Product_category();
//        category.setId(categoryId);  // Assuming the Product_category entity has a setId method
//        return category;
//    }

    // Map from Products entity to DTO
    // Map Product entity to ProductResponseDTO (used for response after saving)
    ProductResponseDTO toResponseDto(Products product);

    // Map ProductDTO to Product entity
    @Mapping(target = "id", ignore = true)  // Don't map the ID during creation
    @Mapping(target = "category", source = "categoryId")  // Map categoryId to the category field
    Products toEntity(ProductDTO dto);

    // Custom method to map categoryId to a Product_category entity
    default Product_category mapCategoryIdToCategory(Long categoryId) {
        if (categoryId == null) {
            return null;  // Handle if categoryId is null
        }

        // Assuming you have a way to find a Product_category by its ID,
        // such as using a repository. Replace this with actual lookup logic:
        Product_category category = new Product_category();
        category.setId(categoryId);
        return category;
    }

}



