package com.Sathish.Ecommerce.exception;

public class GlobalErrorResponse {

    private int status;
    private String message;
    private long timestamp;
    //default constructor
    public GlobalErrorResponse() {
    }
    //parameterized constructor
    public GlobalErrorResponse(int status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    //getters and setters
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
