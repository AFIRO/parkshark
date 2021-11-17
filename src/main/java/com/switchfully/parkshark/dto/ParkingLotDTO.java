package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.Address;
import com.switchfully.parkshark.entity.Category;
import com.switchfully.parkshark.entity.Division;
import com.switchfully.parkshark.entity.Employee;

public class ParkingLotDTO {

    private int parkingLotId;
    private String name;
    private int maxCapacity;
    private double hourlyPrice;
    private Category category;
    private Address parkingLotAddress;
    private Employee employee;
    private Division division;

    public ParkingLotDTO(int parkingLotId, String name, int maxCapacity, double hourlyPrice, Category category, Address parkingLotAddress, Employee employee, Division division) {
        this.parkingLotId = parkingLotId;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.hourlyPrice = hourlyPrice;
        this.category = category;
        this.parkingLotAddress = parkingLotAddress;
        this.employee = employee;
        this.division = division;
    }


    public static final class ParkingLotDTOBuilder {
        private int parkingLotId;
        private String name;
        private int maxCapacity;
        private double hourlyPrice;
        private Category category;
        private Address parkingLotAddress;
        private Employee employee;
        private Division division;

        private ParkingLotDTOBuilder() {
        }

        public static ParkingLotDTOBuilder aParkingLotDTO() {
            return new ParkingLotDTOBuilder();
        }

        public ParkingLotDTOBuilder withParkingLotId(int parkingLotId) {
            this.parkingLotId = parkingLotId;
            return this;
        }

        public ParkingLotDTOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ParkingLotDTOBuilder withMaxCapacity(int maxCapacity) {
            this.maxCapacity = maxCapacity;
            return this;
        }

        public ParkingLotDTOBuilder withHourlyPrice(double hourlyPrice) {
            this.hourlyPrice = hourlyPrice;
            return this;
        }

        public ParkingLotDTOBuilder withCategory(Category category) {
            this.category = category;
            return this;
        }

        public ParkingLotDTOBuilder withParkingLotAddress(Address parkingLotAddress) {
            this.parkingLotAddress = parkingLotAddress;
            return this;
        }

        public ParkingLotDTOBuilder withEmployee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public ParkingLotDTOBuilder withDivision(Division division) {
            this.division = division;
            return this;
        }

        public ParkingLotDTO build() {
            return new ParkingLotDTO(parkingLotId, name, maxCapacity, hourlyPrice, category, parkingLotAddress, employee, division);
        }
    }
}
