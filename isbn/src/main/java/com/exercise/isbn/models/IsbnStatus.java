package com.exercise.isbn.models;

public class IsbnStatus {
    
    private boolean hasError = false;
    private String message = ""; 

    public IsbnStatus(boolean hasError, String message) {
        this.hasError = hasError;
        this.message = message;
    }

    public boolean isHasError() {
        return hasError;
    }

    public String getMessage() {
        return message;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
