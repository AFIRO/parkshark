package com.switchfully.parkshark.entity;


import javax.persistence.*;

@Entity
@Table(name = "parking_lot")
public class ParkingLot {

    public enum Category { UNDER_GROUND_BUILDING, ABOVE_GROUND_GROUND }

    @Id
    @SequenceGenerator(name = "parking_lot_pl_id_seq", sequenceName = "parking_lot_pl_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parking_lot_pl_id_seq")
    @Column(name = "pl_id")
    private int parkingLotId;

    @Column(name = "pl_name")
    private String name;

    @Column(name = "pl_max_cap")
    private int maxCapacity;

    @Column(name = "pl_price_hour")
    private double hourlyPrice;

    @Column(name = "pl_category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pl_address_id")
    private Address parkingLotAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pl_contact_id")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pl_div_id")
    private Division division;

    public ParkingLot() {
    }

    private ParkingLot(String name, int maxCapacity, double hourlyPrice, Category category, Address parkingLotAddress, Employee employee, Division division) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.hourlyPrice = hourlyPrice;
        this.category = category;
        this.parkingLotAddress = parkingLotAddress;
        this.employee = employee;
        this.division = division;
    }


    public static final class ParkingLotBuilder {
        private String name;
        private int maxCapacity;
        private double hourlyPrice;
        private Category category;
        private Address parkingLotAddress;
        private Employee employee;
        private Division division;


        public ParkingLotBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ParkingLotBuilder withMaxCapacity(int maxCapacity) {
            this.maxCapacity = maxCapacity;
            return this;
        }

        public ParkingLotBuilder withHourlyPrice(double hourlyPrice) {
            this.hourlyPrice = hourlyPrice;
            return this;
        }

        public ParkingLotBuilder withCategory(Category category) {
            this.category = category;
            return this;
        }

        public ParkingLotBuilder withParkingLotAddress(Address parkingLotAddress) {
            this.parkingLotAddress = parkingLotAddress;
            return this;
        }

        public ParkingLotBuilder withEmployee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public ParkingLotBuilder withDivision(Division division) {
            this.division = division;
            return this;
        }

        public ParkingLot build() {
            return new ParkingLot(name, maxCapacity, hourlyPrice, category, parkingLotAddress, employee, division);
        }
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

    public Category getCategory() {
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

    public int getParkingLotId() {
        return parkingLotId;
    }
}
