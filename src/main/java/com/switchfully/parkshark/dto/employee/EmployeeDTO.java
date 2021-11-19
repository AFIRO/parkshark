package com.switchfully.parkshark.dto.employee;

import com.switchfully.parkshark.entity.Address;
import com.switchfully.parkshark.entity.ParkingLot;

public class EmployeeDTO {

    private final int directorId;
    private final String firstName;
    private final String lastName;
    private final String mobileNumber;
    private final String telephoneNumber;
    private final Address address;
    private final ParkingLot parkingLot;
    private final String email;
    private final String empTitle;

    public EmployeeDTO(int directorId, String firstName, String lastName, String mobileNumber, String telephoneNumber, Address address, ParkingLot parkingLot, String email, String empTitle) {
        this.directorId = directorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        this.parkingLot = parkingLot;
        this.email = email;
        this.empTitle = empTitle;
    }

    public int getDirectorId() {
        return directorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public String getEmail() {
        return email;
    }

    public String getEmpTitle() {
        return empTitle;
    }

    public static final class Builder {
        private int directorId;
        private String firstName;
        private String lastName;
        private String mobileNumber;
        private String telephoneNumber;
        private Address address;
        private ParkingLot parkingLot;
        private String email;
        private String empTitle;

        public Builder withDirectorId(int directorId) {
            this.directorId = directorId;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public Builder withTelephoneNumber(String telephoneNumber) {
            this.telephoneNumber = telephoneNumber;
            return this;
        }

        public Builder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder withParkingLot(ParkingLot parkingLot) {
            this.parkingLot = parkingLot;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withEmpTitle(String empTitle) {
            this.empTitle = empTitle;
            return this;
        }

        public EmployeeDTO build() {
            return new EmployeeDTO(directorId, firstName, lastName, mobileNumber, telephoneNumber, address, parkingLot, email, empTitle);
        }
    }
}
