package com.switchfully.parkshark.exceptions.parkinglot;

public class BadCreateParkingLotException extends RuntimeException {
    public static final String BAD_CREATE_PARKING_LOT = "Input for creating parking lot invalid";

    public BadCreateParkingLotException() {
        super(BAD_CREATE_PARKING_LOT);
    }

    public BadCreateParkingLotException(String message) {
        super(message);
    }
}
