package com.Sathish.Ecommerce.controller;

import com.Sathish.Ecommerce.dao.AuthoritiesRepository;
import com.Sathish.Ecommerce.dao.UserRepository;
import com.Sathish.Ecommerce.entity.authority;
import com.Sathish.Ecommerce.entity.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserRepository userRepository;
    private AuthoritiesRepository authoritiesRepository;

    @Autowired
    public UserController(UserRepository userRepository, AuthoritiesRepository authoritiesRepository) {
        this.authoritiesRepository = authoritiesRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/showLoginPage")
    public String showLoginPage() {
        return "login-page"; // Corresponds to login-page.html in the templates folder
    }


    @GetMapping("/showRegistrationPage")
    public String showRegistrationPage(Model model) {
        users user = new users();
        model.addAttribute("users", user);
        return "registration-page";
    }

    @PostMapping("/registeruser")
    public String registerUser(@ModelAttribute("users") users user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration-page";
        } else {
            // Add {noop} to the password
            user.setPassword("{noop}" + user.getPassword());

            userRepository.save(user);

            authority authority = new authority();
            authority.setUsername(user.getUsername());
            authority.setAuthority("ROLE_USER");
            authoritiesRepository.save(authority);

            return "redirect:/api/products";
        }
    }

    @GetMapping()
    public String showContinuePage() {
        return "redirect:/api/products";
    }
}