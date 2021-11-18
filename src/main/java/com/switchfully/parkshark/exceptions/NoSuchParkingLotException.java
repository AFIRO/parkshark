package com.switchfully.parkshark.exceptions;

public class NoSuchParkingLotException extends RuntimeException {
    private static final String NO_SUCH_PARKING_LOT = "The requested parking lot is not in our database";

    public NoSuchParkingLotException() {
        super(NO_SUCH_PARKING_LOT);
    }

    public NoSuchParkingLotException(String message) {
        super(message);
    }
}
