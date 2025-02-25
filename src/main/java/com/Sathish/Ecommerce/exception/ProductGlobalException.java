package com.Sathish.Ecommerce.exception;

public class ProductGlobalException extends RuntimeException {

    // Constructor with custom message
    public ProductGlobalException(String message) {
        super(message);
    }

    public ProductGlobalException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductGlobalException(Throwable cause) {
        super(cause);
    }

    public ProductGlobalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    // No-argument constructor with default message
    public ProductGlobalException() {
        super("A product-related error occurred.");
    }
}
