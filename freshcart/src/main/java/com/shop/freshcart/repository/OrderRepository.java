package com.shop.freshcart.repository;

import com.shop.freshcart.entities.Order;
import com.shop.freshcart.entities.Order_items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);

}
