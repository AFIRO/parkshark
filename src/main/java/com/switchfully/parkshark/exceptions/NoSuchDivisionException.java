package com.switchfully.parkshark.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoSuchDivisionException extends RuntimeException {

    private static final String NO_SUCH_DIVISION_EXCEPTION = "Not a valid ID.";

    public NoSuchDivisionException() {
        super(NO_SUCH_DIVISION_EXCEPTION);
    }

}
