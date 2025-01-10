package com.Sathish.Ecommerce.service;

import com.Sathish.Ecommerce.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> findAll();
    public Optional<Product> findById(Integer id);
    public List<Product> findByCategory(String category);
    public List<String> findAllCategories();
    List<Product> filterProducts(String category, Double minPrice, Double maxPrice);
}
