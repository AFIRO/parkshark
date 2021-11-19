package com.switchfully.parkshark.exceptions.member;

public class BadCreateLicensePlateException extends RuntimeException {
    public static final String DEFAULT_MESSAGE = "Input for creating a License Plate invalid";

    public BadCreateLicensePlateException() {
        super(DEFAULT_MESSAGE);
    }

    public BadCreateLicensePlateException(String message) {
        super(message);
    }
}
