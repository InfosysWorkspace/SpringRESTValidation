package com.infy.entity;

import com.infy.dto.AddressDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String name;
    private String emailId;
    private LocalDate dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", unique = true)
    private Address address;

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public void setEmailId(final String emailId) {
        this.emailId = emailId;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(final LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", addressDTO=" + address +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (null == o || this.getClass() != o.getClass()) return false;
        final Customer customer = (Customer) o;
        return this.customerId.equals(customer.customerId) && this.name.equals(customer.name) && this.emailId.equals(customer.emailId) && this.dateOfBirth.equals(customer.dateOfBirth) && this.address.equals(customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.customerId, this.name, this.emailId, this.dateOfBirth, this.address);
    }



}
