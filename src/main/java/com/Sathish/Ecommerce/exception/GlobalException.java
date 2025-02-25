package com.Sathish.Ecommerce.exception;

public class GlobalException extends Exception {
    public GlobalException(String message) {
        super(message);

    }

    public GlobalException(String message, Throwable cause) {
        super(message, cause);
    }

    public GlobalException(Throwable cause) {
        super(cause);
    }

    public GlobalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public GlobalException() {
    }
}

