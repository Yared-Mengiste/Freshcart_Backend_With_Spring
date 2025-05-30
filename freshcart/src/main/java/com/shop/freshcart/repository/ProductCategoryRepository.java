package com.shop.freshcart.repository;

import com.shop.freshcart.entities.Product_category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<Product_category, Long> {
}
