package com.Sathish.Ecommerce.controller;

import com.Sathish.Ecommerce.entity.Cart;
import com.Sathish.Ecommerce.entity.Product;
import com.Sathish.Ecommerce.service.CartService;
import com.Sathish.Ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class CheckOutController {

    private final CartService cartService;
    private final ProductService productService;

    @Autowired
    public CheckOutController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @RequestMapping(value = "/checkout", method = {RequestMethod.GET, RequestMethod.POST})
    public String checkout(
            @RequestParam(required = false) Integer productId,
            @RequestParam(required = false) Integer quantity,
            Model model) {

        List<Cart> cartItems = new ArrayList<>();
        BigDecimal totalPrice = BigDecimal.ZERO;

        // Handle "Buy Now" action
        if (productId != null && quantity != null) {
            Product product = productService.findById(productId)
                    .orElseThrow(() -> new IllegalArgumentException("Product with ID " + productId + " not found."));
            Cart tempCart = new Cart();
            tempCart.setProduct(product);
            tempCart.setQuantity(quantity);
            tempCart.setTotalPrice(product.getPrice().multiply(BigDecimal.valueOf(quantity)));

            cartItems.add(tempCart);
            totalPrice = totalPrice.add(tempCart.getTotalPrice());
        }
        // Handle "Checkout from Cart"
        else {
            cartItems = cartService.findAll();
            totalPrice = cartItems.stream()
                    .map(Cart::getTotalPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        // Add data to the model
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalPrice", totalPrice);

        return "checkout"; // Ensure checkout.html exists in templates folder
    }

    @RequestMapping("/placeOrder")
    public String placeOrder() {
        // Handle order placement logic here
        return "order_placed"; // Ensure order_placed.html exists in templates folder
    }
}
