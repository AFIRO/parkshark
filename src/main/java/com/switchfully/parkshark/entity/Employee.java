package com.switchfully.parkshark.entity;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @SequenceGenerator(name = "employee_emp_id_seq", sequenceName = "employee_emp_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_emp_id_seq")
    @Column(name = "emp_id")
    private int id;

    @Column(name = "emp_firstname")
    private String firstName;

    @Column(name = "emp_lastname")
    private String lastName;

    @Column(name = "emp_mobilephonenumber")
    private String mobileNumber;

    @Column(name = "emp_telephonenumber")
    private String telephoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_address")
    private Address address;

    @OneToOne(mappedBy = "parkingLotAddress")
    private ParkingLot parkingLot;

    @Column(name = "emp_email_address")
    private String email;

    @Column(name = "emp_title")
    private String empTitle;

    public Employee() {
    }

    private Employee(String firstName, String lastName, String mobileNumber, String telephoneNumber, Address address, ParkingLot parkingLot, String email, String empTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        this.parkingLot = parkingLot;
        this.email = email;
        this.empTitle = empTitle;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public String getEmail() {
        return email;
    }

    public String getEmpTitle() {
        return empTitle;
    }

    public static final class EmployeeBuilder {
        private String firstName;
        private String lastName;
        private String mobileNumber;
        private String telephoneNumber;
        private Address address;
        private ParkingLot parkingLot;
        private String email;
        private String empTitle;

        private EmployeeBuilder() {
        }

        public static EmployeeBuilder anEmployee() {
            return new EmployeeBuilder();
        }

        public EmployeeBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeeBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeeBuilder withMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public EmployeeBuilder withTelephoneNumber(String telephoneNumber) {
            this.telephoneNumber = telephoneNumber;
            return this;
        }

        public EmployeeBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public EmployeeBuilder withParkingLot(ParkingLot parkingLot) {
            this.parkingLot = parkingLot;
            return this;
        }

        public EmployeeBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public EmployeeBuilder withEmpTitle(String empTitle) {
            this.empTitle = empTitle;
            return this;
        }

        public Employee build() {
            return new Employee(firstName, lastName, mobileNumber, telephoneNumber, address, parkingLot, email, empTitle);
        }
    }
}
