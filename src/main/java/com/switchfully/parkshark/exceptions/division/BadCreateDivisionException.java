package com.switchfully.parkshark.exceptions.division;

public class BadCreateDivisionException extends RuntimeException{
    public static final String DEFAULT_MESSAGE = "Input for creating Division invalid";

    public BadCreateDivisionException() {
        super(DEFAULT_MESSAGE);
    }
}
