package com.switchfully.parkshark.dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class CreateAddressDTO {
    private String street;
    private String houseNumber;
    private String zipcode;
    private String city;

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public CreateAddressDTO(String street, String houseNumber, String zipcode, String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipcode = zipcode;
        this.city = city;
    }
}
