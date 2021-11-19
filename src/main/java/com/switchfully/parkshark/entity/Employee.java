package com.switchfully.parkshark.entity;

import com.switchfully.parkshark.exceptions.BadCreateEmployeeException;
import com.switchfully.parkshark.exceptions.member.BadCreateMemberException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @SequenceGenerator(name = "employee_emp_id_seq", sequenceName = "employee_emp_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_emp_id_seq")
    @Column(name = "emp_id")
    private int employeeId;

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

    public Employee(String firstName, String lastName, String mobileNumber, String telephoneNumber, Address address, ParkingLot parkingLot, String email, String empTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        this.parkingLot = parkingLot;
        this.email = isValidEmailAddress(email);
        this.empTitle = empTitle;
    }

    public int getEmployeeId() {
        return employeeId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId;
    }

    public String isValidEmailAddress(String email) {
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            throw new BadCreateEmployeeException();
        }
        return email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    public static final class Builder {
        private String firstName;
        private String lastName;
        private String mobileNumber;
        private String telephoneNumber;
        private Address address;
        private ParkingLot parkingLot;
        private String email;
        private String empTitle;

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public Builder withTelephoneNumber(String telephoneNumber) {
            this.telephoneNumber = telephoneNumber;
            return this;
        }

        public Builder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder withParkingLot(ParkingLot parkingLot) {
            this.parkingLot = parkingLot;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withEmpTitle(String empTitle) {
            this.empTitle = empTitle;
            return this;
        }

        public Employee build() {
            return new Employee(firstName, lastName, mobileNumber, telephoneNumber, address, parkingLot, email, empTitle);
        }
    }
}
