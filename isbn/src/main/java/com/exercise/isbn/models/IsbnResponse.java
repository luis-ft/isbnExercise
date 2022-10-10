package com.exercise.isbn.models;

public class IsbnResponse {
    
    private Isbn isbn; 
    private IsbnStatus status;

    public IsbnResponse(Isbn isbn, IsbnStatus status) {
        this.isbn = isbn;
        this.status = status;
    }

    public Isbn getIsbn() {
        return isbn;
    }

    public void setIsbn(Isbn Isbn) {
        this.isbn = Isbn;
    }

    public IsbnStatus getStatus() {
        return status;
    }

    public void setStatus(IsbnStatus status) {
        this.status = status;
    }

}
