package com.shop.freshcart.service;

import com.shop.freshcart.dto.ProductDTO;
import com.shop.freshcart.dto.ProductResponseDTO;
import com.shop.freshcart.entities.Product_category;
import com.shop.freshcart.entities.Products;
import com.shop.freshcart.exception.ProductAlreadyExistsException;
import com.shop.freshcart.exception.ResourceNotFoundException;
import com.shop.freshcart.mapper.AddProductMapper;
import com.shop.freshcart.mapper.UpdateProductMapper;
import com.shop.freshcart.repository.ProductCategoryRepository;
import com.shop.freshcart.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final AddProductMapper addProductMapper;
    private final ProductCategoryRepository categoryRepository;
    private final UpdateProductMapper updateProductMapper;

    // Add Product
    public Products addProduct(ProductDTO dto) {
        if (productRepository.existsByName(dto.getName())) {
            throw new ProductAlreadyExistsException("Product with this name already exists");
        }

        var category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Invalid category ID"));

        Products product = addProductMapper.toEntity(dto);
        product.setCategory(category);

        return productRepository.save(product);
    }

    // Get All Products
    @Caching(evict = {
            @CacheEvict(value = "allProducts", allEntries = true)
    })
    @Cacheable(value = "allProducts")
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    // Get Product By ID
    @Cacheable(value = "products", key = "#id")
    public Products getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    // Update Product Price
    @Caching(evict = {
            @CacheEvict(value = "products", key = "#productId"),
            @CacheEvict(value = "allProducts", allEntries = true)
    })
    public Products updatePrice(Long productId, ProductDTO dto) {
        Products existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        updateProductMapper.updateProductFromDto(dto, existingProduct);

        return productRepository.save(existingProduct);
    }

    // Delete Product
    @Caching(evict = {
            @CacheEvict(value = "products", key = "#productId"),
            @CacheEvict(value = "allProducts", allEntries = true)
    })
    public void deleteProduct(Long productId) {
        Products product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        productRepository.delete(product);
    }
}

