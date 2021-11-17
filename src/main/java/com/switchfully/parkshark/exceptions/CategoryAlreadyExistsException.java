package com.switchfully.parkshark.exceptions;

public class CategoryAlreadyExistsException extends RuntimeException {

    private static final String CATEGORY_ALREADY_EXISTS = "Category already exists.";

    public CategoryAlreadyExistsException() {
        super(CATEGORY_ALREADY_EXISTS);
    }
}
