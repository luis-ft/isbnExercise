package com.exercise.isbn.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.isbn.models.Isbn;
import com.exercise.isbn.models.IsbnResponse;
import com.exercise.isbn.models.IsbnStatus;

@RestController
@RequestMapping("api/v1/isbn")
public class IsbnRestController {
    
    @GetMapping("/{StrIsbn}")
    public IsbnResponse getIsbn(@PathVariable String StrIsbn) {
        IsbnResponse r = new IsbnResponse(new Isbn(StrIsbn), new IsbnStatus(false, null));
        String message = Isbn.validateIsbn(StrIsbn);
        boolean hasError = !message.equals("Isbn is valid");

        r.getStatus().setMessage(message);
        r.getStatus().setHasError(hasError);

        return r;
    }

    /*call this method when the path param is empty*/
    @GetMapping("")
    public IsbnResponse getNoIsbn() {
        String StrIsbn = "";
        
        IsbnResponse r = new IsbnResponse(new Isbn(StrIsbn), new IsbnStatus(false, null));
        String message = Isbn.validateIsbn(StrIsbn);
        boolean hasError = !message.equals("Isbn is valid");

        r.getStatus().setMessage(message);
        r.getStatus().setHasError(hasError);

        return r;
    }

}
