package com.Sathish.Ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle ProductGlobalException
    @ExceptionHandler(ProductGlobalException.class)
    public ResponseEntity<ProductErrorResponse> handleProductException(ProductGlobalException ex) {
        ProductErrorResponse error = new ProductErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Handle generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProductErrorResponse> handleGenericException(Exception ex) {
        ProductErrorResponse error = new ProductErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid request: " + ex.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
