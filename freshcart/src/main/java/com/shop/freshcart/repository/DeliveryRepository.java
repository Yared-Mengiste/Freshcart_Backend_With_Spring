package com.shop.freshcart.repository;

import com.shop.freshcart.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByUserId(Long userId);
    List<Delivery> findByDriverId(Long driverId);
}
