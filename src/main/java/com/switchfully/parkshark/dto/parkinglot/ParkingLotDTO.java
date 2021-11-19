package com.switchfully.parkshark.dto.parkinglot;

import com.switchfully.parkshark.dto.address.AddressDTO;
import com.switchfully.parkshark.dto.division.DivisionDTO;
import com.switchfully.parkshark.dto.employee.EmployeeDTO;
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
    private final AddressDTO parkingLotAddress;
    private final EmployeeDTO employee;
    private final DivisionDTO division;

    public ParkingLotDTO(int parkingLotId, String name, int maxCapacity, double hourlyPrice, ParkingLot.Category category, AddressDTO parkingLotAddress, EmployeeDTO employee, DivisionDTO division) {
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

    public AddressDTO getParkingLotAddress() {
        return parkingLotAddress;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public DivisionDTO getDivision() {
        return division;
    }

    public static final class Builder {
        private int parkingLotId;
        private String name;
        private int maxCapacity;
        private double hourlyPrice;
        private ParkingLot.Category category;
        private AddressDTO parkingLotAddress;
        private EmployeeDTO employee;
        private DivisionDTO division;


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

        public Builder withParkingLotAddress(AddressDTO parkingLotAddress) {
            this.parkingLotAddress = parkingLotAddress;
            return this;
        }

        public Builder withEmployee(EmployeeDTO employee) {
            this.employee = employee;
            return this;
        }

        public Builder withDivision(DivisionDTO division) {
            this.division = division;
            return this;
        }

        public ParkingLotDTO build() {
            return new ParkingLotDTO(parkingLotId, name, maxCapacity, hourlyPrice, category, parkingLotAddress, employee, division);
        }
    }
}
