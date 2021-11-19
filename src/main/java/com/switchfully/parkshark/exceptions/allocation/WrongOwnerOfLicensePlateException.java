package com.switchfully.parkshark.exceptions.allocation;

public class WrongOwnerOfLicensePlateException extends RuntimeException {

    private static final String LICENSE_PLATE_WRONG_OWNER = "You cannot enter with a different license plate.";

    public WrongOwnerOfLicensePlateException() {
        super(LICENSE_PLATE_WRONG_OWNER);
    }
}