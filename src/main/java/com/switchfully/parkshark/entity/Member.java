package com.switchfully.parkshark.entity;

import com.switchfully.parkshark.exceptions.member.BadCreateMemberException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "member")
public class Member {

    public enum MembershipLevel {BRONZE, SILVER, GOLD}

    @Id
    @SequenceGenerator(name = "member_mem_id_seq", sequenceName = "member_mem_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_mem_id_seq")
    @Column(name = "mem_id", nullable = false)
    private Integer memberId;

    @Column(name = "mem_firstname")
    private String firstName;

    @Column(name = "mem_lastname")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mem_address_id")
    private Address address;

    @Column(name = "mem_email_address")
    private String email;

    @Column(name = "mem_telephone_number")
    private String telephoneNumber;

    @Column(name = "mem_reg_date", columnDefinition = "DATE")
    private LocalDate registrationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mem_lp_id")
    private LicensePlate licensePlate;

    @Column(name = "mem_msl")
    @Enumerated(EnumType.STRING)
    private MembershipLevel membershipLevel;

    public Member() {

    }

    public Member(String firstName, String lastName, Address address, String email, String telephoneNumber, LocalDate registrationDate, LicensePlate licensePlate, MembershipLevel membershipLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = isValidEmailAddress(email);
        this.telephoneNumber = telephoneNumber;
        this.registrationDate = registrationDate;
        this.licensePlate = licensePlate;
        this.membershipLevel = membershipLevel;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public MembershipLevel getMembershipLevel() {
        return membershipLevel;
    }

    public String isValidEmailAddress(String email) {
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            throw new BadCreateMemberException();
        }
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        Member member = (Member) o;
        if (getMemberId() == null || member.getMemberId() == null) return false;
        return getMemberId().equals(member.getMemberId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMemberId());
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private Address address;
        private String email;
        private String telephoneNumber;
        private LocalDate registrationDate;
        private LicensePlate licensePlate;
        private MembershipLevel membershipLevel;

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withTelephoneNumber(String telephoneNumber) {
            this.telephoneNumber = telephoneNumber;
            return this;
        }

        public Builder withRegistrationDate(LocalDate registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Builder withLicensePlate(LicensePlate licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }

        public Builder withMembershipLevel(MembershipLevel membershipLevel) {
            this.membershipLevel = membershipLevel;
            return this;
        }

        public Member build() {
            return new Member(firstName, lastName, address, email, telephoneNumber, registrationDate, licensePlate, membershipLevel);
        }
    }


}
