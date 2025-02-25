package com.Sathish.Ecommerce.exception;

public class CartException extends RuntimeException {
    public CartException() {
    }

    public CartException(String message) {
        super(message);
    }

    public CartException(String message, Throwable cause) {
        super(message, cause);
    }

    public CartException(Throwable cause) {
        super(cause);
    }

    public CartException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
