package com.Sathish.Ecommerce.exception;

public class ProductErrorResponse {
    private int status;          // HTTP status code
    private String message;      // Error message
    private long timestamp;      // Time of the error

    // Default constructor
    public ProductErrorResponse() {
    }

    // Parameterized constructor
    public ProductErrorResponse(int status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    // Getters and setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
