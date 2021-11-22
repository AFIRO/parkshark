package com.switchfully.parkshark.exceptions.division;

public class NoSuchDivisionException extends RuntimeException {

    private static final String NO_SUCH_DIVISION_EXCEPTION = "Not a valid Division ID.";

    public NoSuchDivisionException() {
        super(NO_SUCH_DIVISION_EXCEPTION);
    }

}
