package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.Address;

public class CreateEmployeeDTO {
    private final String firstName;
    private final String lastName;
    private final String mobileNumber;
    private final String telephoneNumber;
    private final Address address;
    private final String email;
    private final String empTitle;

    private CreateEmployeeDTO(String firstName, String lastName, String mobileNumber, String telephoneNumber, Address address, String email, String empTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        this.email = email;
        this.empTitle = empTitle;

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

    public String getEmail() {
        return email;
    }

    public String getEmpTitle() {
        return empTitle;
    }

}
