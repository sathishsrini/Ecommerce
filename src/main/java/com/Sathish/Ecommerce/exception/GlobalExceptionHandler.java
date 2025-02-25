package com.Sathish.Ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle Product Not Found Exception
    @ExceptionHandler(ProductGlobalException.class)
    public ResponseEntity<GlobalErrorResponse> handleProductException(ProductGlobalException ex) {
        GlobalErrorResponse error = new GlobalErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Handle User Not Found Exception
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<GlobalErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
        GlobalErrorResponse error = new GlobalErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Handle Cart Exception
    @ExceptionHandler(CartException.class)
    public ResponseEntity<GlobalErrorResponse> handleCartException(CartException ex) {
        GlobalErrorResponse error = new GlobalErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Handle Checkout Exception
    @ExceptionHandler(CheckoutException.class)
    public ResponseEntity<GlobalErrorResponse> handleCheckoutException(CheckoutException ex) {
        GlobalErrorResponse error = new GlobalErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Handle Access Denied Exception (for security errors)

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<GlobalErrorResponse> handleAccessDeniedException(AccessDeniedException ex) {
        GlobalErrorResponse error = new GlobalErrorResponse(
                HttpStatus.FORBIDDEN.value(),
                "Access denied: " + ex.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }

    // Handle generic exceptions (for all other unhandled errors)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalErrorResponse> handleGenericException(Exception ex) {
        GlobalErrorResponse error = new GlobalErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An unexpected error occurred: " + ex.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
