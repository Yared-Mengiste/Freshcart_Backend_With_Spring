package com.shop.freshcart.repository;

import com.shop.freshcart.entities.Order_items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<Order_items, Long> {
    List<Order_items> findByOrderId(Long orderId);
}
