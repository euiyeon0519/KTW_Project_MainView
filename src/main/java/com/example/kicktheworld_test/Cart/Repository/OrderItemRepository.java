package com.example.kicktheworld_test.Cart.Repository;

import com.example.kicktheworld_test.Cart.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
