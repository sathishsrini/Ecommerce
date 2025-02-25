package com.Sathish.Ecommerce.exception;

public class CheckoutException extends RuntimeException {
    public CheckoutException() {
    }

    public CheckoutException(String message) {
        super(message);
    }

    public CheckoutException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckoutException(Throwable cause) {
        super(cause);
    }

    public CheckoutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
