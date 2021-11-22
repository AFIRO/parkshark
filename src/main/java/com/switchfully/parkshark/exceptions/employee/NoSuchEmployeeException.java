package com.switchfully.parkshark.exceptions.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NoSuchEmployeeException extends RuntimeException {

    private static final String INVALID_EMPLOYEE = "Not a valid employee.";

    public NoSuchEmployeeException() {
        super(INVALID_EMPLOYEE);
    }
}
