package com.Sathish.Ecommerce.service;


import com.Sathish.Ecommerce.dao.ProductRepository;
import com.Sathish.Ecommerce.entity.Product;
import com.Sathish.Ecommerce.exception.ProductGlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {

    private ProductRepository productRepository;
    @Autowired
    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Integer id) {
        Optional<Product> pro = productRepository.findById(id);
        if (pro.isPresent()) {
            return pro;
        } else {
            throw new ProductGlobalException("Product with ID " + id + " not found.");
        }
    }

    public List<Product> findByCategory(String category) {
        List<Product> productsByCategory = productRepository.findByCategory(category);
        return productsByCategory;
    }

    public List<String> findAllCategories() {
        return productRepository.findAllCategories(); // Assuming this method exists in your repository
    }


    @Override
    public List<Product> filterProducts(String category, Double minPrice, Double maxPrice) {
        return productRepository.findAll().stream()
                .filter(product -> (category == null || product.getCategory().equalsIgnoreCase(category)))
                .filter(product -> (minPrice == null || product.getPrice().compareTo(BigDecimal.valueOf(minPrice)) >= 0))
                .filter(product -> (maxPrice == null || product.getPrice().compareTo(BigDecimal.valueOf(maxPrice)) <= 0))
                .collect(Collectors.toList());
    }

}
