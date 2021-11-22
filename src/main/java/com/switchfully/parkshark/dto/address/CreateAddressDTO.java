package com.switchfully.parkshark.dto.address;

public class CreateAddressDTO {
    private final String street;
    private final String houseNumber;
    private final String zipcode;
    private final String city;

    public CreateAddressDTO(String street, String houseNumber, String zipcode, String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipcode = zipcode;
        this.city = city;
    }

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
}
