package com.switchfully.parkshark.exceptions.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadCreateEmployeeException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "Input for creating employee invalid";

    public BadCreateEmployeeException() {
        super(DEFAULT_MESSAGE);
    }
}
