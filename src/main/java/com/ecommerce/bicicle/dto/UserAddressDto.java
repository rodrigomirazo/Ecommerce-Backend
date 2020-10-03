package com.ecommerce.bicicle.dto;


import java.io.Serializable;

public class UserAddressDto implements Serializable {

    private static final long serialVersionUID = 6061630455851019613L;
    private int id;
    private UserDto user;
    private String name;
    private String lastnames;
    private String street;
    private String intNumber;
    private String extNumber;
    private String zipCode;
    private String state;
    private String city;
    private String suburb;
    private String reference;
    private String phoneNumber;

    public UserAddressDto() {
    }

    public int getId() {
        return id;
    }

    public UserAddressDto setId(int id) {
        this.id = id;
        return this;
    }

    public UserDto getUser() {
        return user;
    }

    public UserAddressDto setUser(UserDto user) {
        this.user = user;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserAddressDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastnames() {
        return lastnames;
    }

    public UserAddressDto setLastnames(String lastnames) {
        this.lastnames = lastnames;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public UserAddressDto setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getIntNumber() {
        return intNumber;
    }

    public UserAddressDto setIntNumber(String intNumber) {
        this.intNumber = intNumber;
        return this;
    }

    public String getExtNumber() {
        return extNumber;
    }

    public UserAddressDto setExtNumber(String extNumber) {
        this.extNumber = extNumber;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public UserAddressDto setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getState() {
        return state;
    }

    public UserAddressDto setState(String state) {
        this.state = state;
        return this;
    }

    public String getCity() {
        return city;
    }

    public UserAddressDto setCity(String city) {
        this.city = city;
        return this;
    }

    public String getSuburb() {
        return suburb;
    }

    public UserAddressDto setSuburb(String suburb) {
        this.suburb = suburb;
        return this;
    }

    public String getReference() {
        return reference;
    }

    public UserAddressDto setReference(String reference) {
        this.reference = reference;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserAddressDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
