package com.Sathish.Ecommerce.service;

import com.Sathish.Ecommerce.dao.CartRepository;
import com.Sathish.Ecommerce.entity.Cart;
import com.Sathish.Ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImp implements CartService {
    private CartRepository cartRepository;
    private ProductService productService;

    @Autowired
    public CartServiceImp(CartRepository cartRepository, ProductService productService) {
        this.productService = productService;
        this.cartRepository = cartRepository;
    }

    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    public void addToCart(int productId, int quantity) {
        // Fetch the product by its ID (assuming you have a ProductService)
        Product product = productService.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product with ID " + productId + " not found."));

        // Check if the product is already in the cart
        Optional<Cart> existingCartItem = cartRepository.findByProductId(productId);

        if (existingCartItem.isPresent()) {
            // Update quantity if the product is already in the cart
            Cart cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
            cartRepository.save(cartItem);
        } else {
            // Add new item to the cart
            Cart newCartItem = new Cart();
            newCartItem.setProduct(product); // Set the Product object
            newCartItem.setQuantity(quantity);
            cartRepository.save(newCartItem);
        }
    }

//    public void addToCart(Cart cart) {
//        cartRepository.save(cart);
//    }

    public BigDecimal calculateTotalPrice() {
        return cartRepository.findAll().stream()
                .map(Cart::getTotalPrice) // Ensure this method exists in the Cart entity
                .reduce(BigDecimal.ZERO, BigDecimal::add); // Accumulate total prices

    }
    public void remove(int id) {
        cartRepository.deleteById(id);
    }
}
