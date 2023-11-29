package com.example.kicktheworld_test.Cart.Repository;

import com.example.kicktheworld_test.Cart.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
