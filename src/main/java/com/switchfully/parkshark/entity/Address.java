package com.switchfully.parkshark.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @SequenceGenerator(name = "address_add_id_seq", sequenceName = "address_add_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_add_id_seq")
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

    public int getId() {
        return id;
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

    public Address(String street, String houseNumber, String zipcode, String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipcode = zipcode;
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id && Objects.equals(street, address.street) && Objects.equals(houseNumber, address.houseNumber) && Objects.equals(zipcode, address.zipcode) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, houseNumber, zipcode, city);
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
