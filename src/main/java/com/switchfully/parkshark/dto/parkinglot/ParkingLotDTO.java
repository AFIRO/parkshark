package com.switchfully.parkshark.dto.parkinglot;

import com.switchfully.parkshark.entity.Address;
import com.switchfully.parkshark.entity.Division;
import com.switchfully.parkshark.entity.Employee;
import com.switchfully.parkshark.entity.ParkingLot;

public class ParkingLotDTO {

    private final int parkingLotId;
    private final String name;
    private final int maxCapacity;
    private final double hourlyPrice;
    private final ParkingLot.Category category;
    private final Address parkingLotAddress;
    private final Employee employee;
    private final Division division;

    public ParkingLotDTO(int parkingLotId, String name, int maxCapacity, double hourlyPrice, ParkingLot.Category category, Address parkingLotAddress, Employee employee, Division division) {
        this.parkingLotId = parkingLotId;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.hourlyPrice = hourlyPrice;
        this.category = category;
        this.parkingLotAddress = parkingLotAddress;
        this.employee = employee;
        this.division = division;
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

    public double getHourlyPrice() {
        return hourlyPrice;
    }

    public ParkingLot.Category getCategory() {
        return category;
    }

    public Address getParkingLotAddress() {
        return parkingLotAddress;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Division getDivision() {
        return division;
    }

    public static final class Builder {
        private int parkingLotId;
        private String name;
        private int maxCapacity;
        private double hourlyPrice;
        private ParkingLot.Category category;
        private Address parkingLotAddress;
        private Employee employee;
        private Division division;


        public Builder withParkingLotId(int parkingLotId) {
            this.parkingLotId = parkingLotId;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withMaxCapacity(int maxCapacity) {
            this.maxCapacity = maxCapacity;
            return this;
        }

        public Builder withHourlyPrice(double hourlyPrice) {
            this.hourlyPrice = hourlyPrice;
            return this;
        }

        public Builder withCategory(ParkingLot.Category category) {
            this.category = category;
            return this;
        }

        public Builder withParkingLotAddress(Address parkingLotAddress) {
            this.parkingLotAddress = parkingLotAddress;
            return this;
        }

        public Builder withEmployee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public Builder withDivision(Division division) {
            this.division = division;
            return this;
        }

        public ParkingLotDTO build() {
            return new ParkingLotDTO(parkingLotId, name, maxCapacity, hourlyPrice, category, parkingLotAddress, employee, division);
        }
    }
}
