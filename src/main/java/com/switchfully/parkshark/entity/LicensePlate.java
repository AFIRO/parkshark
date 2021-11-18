package com.switchfully.parkshark.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "license_plate")
public class LicensePlate {
    @Id
    @SequenceGenerator(name = "licensePlate_lp_id_seq", sequenceName = "licensePlate_lp_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "licensePlate_lp_id_seq")
    @Column(name = "lp_id", nullable = false)
    private Integer licensePlateId;

    @Column(name = "lp_number")
    private String licensePlateNumber;

    @Column(name = "lp_country")
    private String licensePlateCountry;

    public LicensePlate() {
    }

    public LicensePlate(String licensePlateNumber, String licensePlateCountry) {
        this.licensePlateNumber = licensePlateNumber;
        this.licensePlateCountry = licensePlateCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LicensePlate that = (LicensePlate) o;
        return Objects.equals(licensePlateId, that.licensePlateId) && Objects.equals(licensePlateNumber, that.licensePlateNumber) && Objects.equals(licensePlateCountry, that.licensePlateCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlateId, licensePlateNumber, licensePlateCountry);
    }

    public static class Builder{
        private String licensePlateNumber;
        private String licensePlateCountry;

        public Builder withLicensePlateNumber(String licensePlateNumber) {
            this.licensePlateNumber = licensePlateNumber;
            return this;
        }

        public Builder withLicensePlateCountry(String licensePlateCountry) {
            this.licensePlateCountry = licensePlateCountry;
            return this;
        }

        public LicensePlate build(){
            return new LicensePlate(licensePlateNumber,licensePlateCountry);
        }
    }

    public Integer getLicensePlateId() {
        return licensePlateId;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public String getLicensePlateCountry() {
        return licensePlateCountry;
    }

}
