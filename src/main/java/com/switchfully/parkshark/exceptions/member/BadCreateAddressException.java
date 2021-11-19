package com.switchfully.parkshark.exceptions.member;

public class BadCreateAddressException extends RuntimeException {
    public static final String DEFAULT_MESSAGE = "Input for creating Address invalid";

    public BadCreateAddressException() {
        super(DEFAULT_MESSAGE);
    }

    public BadCreateAddressException(String message) {
        super(message);
    }
}
