package com.switchfully.parkshark.exceptions.member;

public class BadCreateMemberException extends RuntimeException {
    public static final String DEFAULT_MESSAGE = "Input for creating member invalid";

    public BadCreateMemberException() {
        super(DEFAULT_MESSAGE);
    }

    public BadCreateMemberException(String message) {
        super(message);
    }
}
