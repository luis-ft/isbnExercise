package com.exercise.isbn.models;

public class Isbn {
    private String bookNumber;

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public Isbn(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public static String validateIsbn(String StrIsbn) {
        Integer count = 0;
        String message = "";

        if(StrIsbn == null){
            return "Isbn is null";
        }

        if(StrIsbn.isBlank()){
            return "Isbn is blank";
        }

        StrIsbn = StrIsbn.replace("-", "");
        StrIsbn = StrIsbn.replace(" ", "");
        StrIsbn = StrIsbn.trim();

        for(Integer i = 0; i < StrIsbn.length(); i++) {
            if(Character.getNumericValue(StrIsbn.charAt(i)) > -1) {
                count++;
            }         
        }

        if(count > 10) {
            message = validateIsbn13(StrIsbn);
        } else {
            message = validateIsbn10(StrIsbn);
        }        

        return message;
    }

    public static String validateIsbn10(String StrIsbn10) {
        Integer sum = 0;
        Integer weight = 10;

        if(StrIsbn10 == null){
            return "Isbn is null";
        }

        if(StrIsbn10.isBlank()){
            return "Isbn is blank";
        }

        StrIsbn10 = StrIsbn10.replace("-", "");
        StrIsbn10 = StrIsbn10.replace(" ", "");
        StrIsbn10 = StrIsbn10.trim();
        
        if(StrIsbn10.length() != 10) {
            return "Isbn is invalid length";
        }

        try {
            Long.parseLong(StrIsbn10.substring(0, 8));
        } catch (Exception e) {
            return "Isbn is not numeric"; //StrIsbn10.substring(0, 9);
        }

        for(Integer i = 0; i < StrIsbn10.length() - 1; i++) {
            sum += Character.getNumericValue(StrIsbn10.charAt(i)) * weight;
            weight--;
        }

        // the last digit can be roman numeral "X".
        if(StrIsbn10.toUpperCase().endsWith("X")) {
            sum += 10 * weight;
            weight--;
        } else {
            sum += Character.getNumericValue(StrIsbn10.charAt(9)) * weight;
            weight--;
        }

        if(sum % 11 != 0) {
            return "Isbn is invalid"; //Integer.toString(sum);
        }

        return "Isbn is valid";
    }

    public static String validateIsbn13(String StrIsbn13) {
        Integer sum = 0;
        Integer weight = 1;

        if(StrIsbn13 == null){
            return "Isbn is null";
        }

        if(StrIsbn13.isBlank()){
            return "Isbn is blank";
        }

        StrIsbn13 = StrIsbn13.replace("-", "");
        StrIsbn13 = StrIsbn13.replace(" ", "");
        StrIsbn13 = StrIsbn13.trim();
        
        if(StrIsbn13.length() != 13) {
            return "Isbn is invalid length";
        }

        try {
            Long.parseLong(StrIsbn13);
        } catch (Exception e) {
            return "Isbn is not numeric";
        }

        for(Integer i = 0; i < StrIsbn13.length(); i++) {
            weight = 1;

            if(i % 2 != 0) {
                weight = 3;
            }

            sum += Character.getNumericValue(StrIsbn13.charAt(i)) * weight;
        }

        if(sum % 10 != 0) {
            return "Isbn is invalid"; //Integer.toString(sum);
        }

        return "Isbn is valid";
    }
}
