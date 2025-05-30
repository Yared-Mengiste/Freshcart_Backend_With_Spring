package com.shop.freshcart.repository;

import com.shop.freshcart.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    Optional<Shop> findFirstBySubcityIgnoreCase(String subcity);
}
