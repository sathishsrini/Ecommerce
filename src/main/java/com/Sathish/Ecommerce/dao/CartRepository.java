package com.Sathish.Ecommerce.dao;

import com.Sathish.Ecommerce.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Optional<Cart> findByProductId(@Param("productId") int productId);

}
