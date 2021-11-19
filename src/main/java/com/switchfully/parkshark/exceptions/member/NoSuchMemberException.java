package com.switchfully.parkshark.exceptions.member;

public class NoSuchMemberException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "The requested member is not in our database";

    public NoSuchMemberException() {
        super(DEFAULT_MESSAGE);
    }

    public NoSuchMemberException(String message) {
        super(message);
    }
}
