package com.Sathish.Ecommerce.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

//    @ExceptionHandler
//    public ResponseEntity<String> handleGenericException(Exception ex) { // Handle generic exceptions
//        return ResponseEntity.badRequest().body("Invalid request: " + ex.getMessage());
//    }
}

