package com.Sathish.Ecommerce.controller;

import com.Sathish.Ecommerce.entity.Product;
import com.Sathish.Ecommerce.exception.ProductGlobalException;
import com.Sathish.Ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getProducts(Model themodel) {
        List<Product> products = productService.findAll();
        List<String> categories = productService.findAllCategories();

        themodel.addAttribute("product", products);
        themodel.addAttribute("categories", categories);
        return "products";
    }

    @GetMapping("/products/{id}")
    public String getProductById(@PathVariable int id, Model themodel) {
        try {
            Optional<Product> product = productService.findById(id);
            if (product.isEmpty()) {
                throw new ProductGlobalException("Product with ID " + id + " not found.");
            }

            themodel.addAttribute("product", List.of(product.get()));
            themodel.addAttribute("errorMessage", null);
        } catch (ProductGlobalException e) {
            List<Product> allProducts = productService.findAll();
            themodel.addAttribute("product", allProducts);
            themodel.addAttribute("errorMessage", e.getMessage());
        }

        return "products";
    }

    @GetMapping("/products/category/{category}")
    public String getProductsByCategory(@PathVariable String category, Model themodel) {
        List<Product> productsByCategory = productService.findByCategory(category);

        if (productsByCategory.isEmpty()) {
            themodel.addAttribute("errorMessage", "No products found in the category: " + category);
        } else {
            themodel.addAttribute("errorMessage", null);
        }

        themodel.addAttribute("product", productsByCategory);
        return "products";
    }

    @GetMapping("/products/detail/{id}")
    public String getProductDetails(@PathVariable int id, Model themodel) {
        Optional<Product> product = productService.findById(id);

        if (product.isEmpty()) {
            throw new ProductGlobalException("Product with ID " + id + " not found.");
        }

        themodel.addAttribute("product", product.get());
        return "product-detail";
    }

    @GetMapping("/products/filter")
    public String filterProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            Model themodel) {

        List<Product> filteredProducts = productService.filterProducts(category, minPrice, maxPrice);
        List<String> categories = productService.findAllCategories();

        if (filteredProducts.isEmpty()) {
            themodel.addAttribute("errorMessage", "No products found matching the criteria.");
        } else {
            themodel.addAttribute("errorMessage", null);
        }

        themodel.addAttribute("product", filteredProducts);
        themodel.addAttribute("categories", categories);
        return "products";
    }

    @GetMapping("/ecommerce")
    public String Ecommerce(Model themodel) {
        return "ecommerce";
    }
}
