package com.switchfully.parkshark.exceptions.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InvalidInputException extends RuntimeException {

    private static final String INVALID_INPUT = "Not a valid input.";

    public InvalidInputException() {
        super(INVALID_INPUT);
    }
}
