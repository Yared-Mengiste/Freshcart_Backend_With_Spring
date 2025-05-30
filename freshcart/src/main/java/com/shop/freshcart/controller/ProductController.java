package com.shop.freshcart.controller;

import com.shop.freshcart.dto.ProductDTO;
import com.shop.freshcart.dto.ProductResponseDTO;
import com.shop.freshcart.entities.Products;
import com.shop.freshcart.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // Endpoint to add a new product
    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody @Valid ProductDTO productDTO) {
        Products product = productService.addProduct(productDTO);
        ProductResponseDTO responseDTO = new ProductResponseDTO(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        List<Products> products = productService.getAllProducts();
        if (products.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No products found");
        }
        List<ProductResponseDTO> responseDTOS = products.stream()
                .map(ProductResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Products product = productService.getProductById(id);
        return ResponseEntity.ok(new ProductResponseDTO(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePrice(@PathVariable Long id, @RequestBody @Valid ProductDTO productDTO) {
        Products updatedProduct = productService.updatePrice(id, productDTO);
        return ResponseEntity.ok(new ProductResponseDTO(updatedProduct));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

}
