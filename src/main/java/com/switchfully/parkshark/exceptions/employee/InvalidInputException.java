package com.switchfully.parkshark.exceptions.employee;

public class InvalidInputException extends RuntimeException {

    private static final String INVALID_INPUT = "Not a valid input.";

    public InvalidInputException() {
        super(INVALID_INPUT);
    }
}
