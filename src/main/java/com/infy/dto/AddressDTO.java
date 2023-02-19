package com.infy.dto;

import jakarta.validation.constraints.NotNull;

public class AddressDTO {
    private Integer addressId;
    @NotNull(message = "please provide street")
    private String street;
    @NotNull(message = "Please provide city")
    private String city;

    public Integer getAddressId() {
        return this.addressId;
    }

    public void setAddressId( Integer addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
