package com.infy.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class CustomerDTO {
    private Integer customerId;
    @Email(message = "{customer.emailid.invalid}")
    @NotNull(message = "customer.emailid.absent")
    private String emailId;
    @NotNull(message = "{customer.name.absent}")
    @Pattern(regexp = "[A-Za-z]+([A-Za-z]+)*", message = "{customer.name.invalid}")
    private String name;
    @PastOrPresent(message = "{customer.dob.invalid}")
    private LocalDate dateOfBirth;
    @NotNull
    @Valid
    private AddressDTO addressDTO;

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final Integer customerId) {
        this.customerId = customerId;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public void setEmailId(final String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(final LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public AddressDTO getAddressDTO() {
        return this.addressDTO;
    }

    public void setAddressDTO(final AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerId=" + customerId +
                ", emailId='" + emailId + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", addressDTO=" + addressDTO +
                '}';
    }
}
