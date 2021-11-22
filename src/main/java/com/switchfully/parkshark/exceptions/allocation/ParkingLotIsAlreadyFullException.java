package com.switchfully.parkshark.exceptions.allocation;

public class ParkingLotIsAlreadyFullException extends RuntimeException {
    private static final String PARKING_LOT_ALREADY_FULL = "The requested parking lot is already full";

    public ParkingLotIsAlreadyFullException() {
        super(PARKING_LOT_ALREADY_FULL);
    }
}
