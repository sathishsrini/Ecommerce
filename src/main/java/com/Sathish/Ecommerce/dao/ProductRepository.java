package com.Sathish.Ecommerce.dao;

import com.Sathish.Ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategory(String category);
    @Query("SELECT DISTINCT p.category FROM Product p")
    List<String> findAllCategories();

}
