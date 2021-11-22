package com.switchfully.parkshark.exceptions.allocation;

public class InvalidMaxResultsInputException extends RuntimeException {

    private static final String INVALID_INPUT = "You cannot enter a negative number to limit the results.";

    public InvalidMaxResultsInputException() {
        super(INVALID_INPUT);
    }
}