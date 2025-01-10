package com.Sathish.Ecommerce.controller;

import com.Sathish.Ecommerce.service.CartService;
import com.Sathish.Ecommerce.service.CartServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.findAll());
        model.addAttribute("totalPrice", cartService.calculateTotalPrice());
        return "cart"; // Ensure cart.html exists in src/main/resources/templates
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam Integer productId, @RequestParam Integer quantity) {
        cartService.addToCart(productId, quantity);
        return "redirect:/api/cart";
    }
    @GetMapping("/cart/remove/{id}")
    public String removeFromCart(@PathVariable int id) {
        cartService.remove(id);
        return "redirect:/api/cart";
    }
}
