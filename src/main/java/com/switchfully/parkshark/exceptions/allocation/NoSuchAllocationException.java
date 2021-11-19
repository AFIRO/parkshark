package com.switchfully.parkshark.exceptions.allocation;

public class NoSuchAllocationException extends RuntimeException {

    private static final String NO_SUCH_ALLOCATION_EXCEPTION = "Not a valid Allocation ID.";

    public NoSuchAllocationException() {
        super(NO_SUCH_ALLOCATION_EXCEPTION);
    }
}
