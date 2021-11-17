package com.switchfully.parkshark.entity;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "add_id")
    private int id;

    @Column(name = "add_street")
    private String street;

    @Column(name = "add_housenum")
    private String houseNumber;

    @Column(name = "add_zipcode")
    private String zipcode;

    @Column(name = "add_city")
    private String city;

    public Address() {

    }


    public Address(String street, String houseNumber, String zipcode, String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipcode = zipcode;
        this.city = city;
    }

    public static class Builder {
        private String street;
        private String houseNumber;
        private String zipcode;
        private String city;

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


        public Address build(){
            return new Address(street,houseNumber,zipcode,city);
        }
    }


}
