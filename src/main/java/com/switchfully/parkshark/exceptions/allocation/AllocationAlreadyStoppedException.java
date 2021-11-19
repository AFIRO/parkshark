package com.switchfully.parkshark.exceptions.allocation;

public class AllocationAlreadyStoppedException extends RuntimeException {

    private static final String ALLOCATION_ALREADY_STOPPED = "This allocation is already stopped.";

    public AllocationAlreadyStoppedException() {
        super(ALLOCATION_ALREADY_STOPPED);
    }
}
