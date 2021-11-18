package com.switchfully.parkshark.dto;

public class ShortenedParkingLotDTO {

    private final int parkingLotId;
    private final String name;
    private final int maxCapacity;
    private final String employeeEmail;
    private final String employeeTelephoneNumber;

    public ShortenedParkingLotDTO(int parkingLotId, String name, int maxCapacity, String employeeEmail, String employeeTelephoneNumber) {
        this.parkingLotId = parkingLotId;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.employeeEmail = employeeEmail;
        this.employeeTelephoneNumber = employeeTelephoneNumber;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public String getName() {
        return name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public String getEmployeeTelephoneNumber() {
        return employeeTelephoneNumber;
    }

    public static final class ParkingLotDTOBuilder {
        private int parkingLotId;
        private String name;
        private int maxCapacity;
        private String employeeEmail;
        private String employeeTelephoneNumber;

        public ParkingLotDTOBuilder withParkingLotId(int parkingLotId) {
            this.parkingLotId = parkingLotId;
            return this;
        }

        public ParkingLotDTOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ParkingLotDTOBuilder withEmployeeEmail(String employeeEmail) {
            this.employeeEmail = employeeEmail;
            return this;
        }

        public ParkingLotDTOBuilder withEmployeeTelephoneNumber(String employeeTelephoneNumber) {
            this.employeeTelephoneNumber = employeeTelephoneNumber;
            return this;
        }

        public ParkingLotDTOBuilder withMaxCapacity(int maxCapacity) {
            this.maxCapacity = maxCapacity;
            return this;


        }

        public ShortenedParkingLotDTO build() {
            return new ShortenedParkingLotDTO(parkingLotId, name, maxCapacity, employeeEmail, employeeTelephoneNumber);
        }
    }
}
