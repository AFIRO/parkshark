package com.switchfully.parkshark.exceptions.allocation;

public class WrongOwnerOfAllocationException extends RuntimeException {

    private static final String ALLOCATION_WRONG_OWNER = "You are not the owner of this allocation.";

    public WrongOwnerOfAllocationException() {
        super(ALLOCATION_WRONG_OWNER);
    }
}
