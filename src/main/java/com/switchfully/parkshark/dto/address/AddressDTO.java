package com.switchfully.parkshark.dto.address;

public class AddressDTO {

    private final int addressId;
    private final String street;
    private final String houseNumber;
    private final String zipcode;
    private final String city;

    public AddressDTO(int addressId, String street, String houseNumber, String zipcode, String city) {
        this.addressId = addressId;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipcode = zipcode;
        this.city = city;
    }

    public int getAddressId() {
        return addressId;
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


    public static final class Builder {
        private int addressId;
        private String street;
        private String houseNumber;
        private String zipcode;
        private String city;

        public Builder withAddressId(int addressId) {
            this.addressId = addressId;
            return this;
        }

        public Builder withStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder withHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        public Builder withZipcode(String zipcode) {
            this.zipcode = zipcode;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public AddressDTO build() {
            return new AddressDTO(addressId, street, houseNumber, zipcode, city);
        }
    }
}
