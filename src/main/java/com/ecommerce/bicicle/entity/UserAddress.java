package com.ecommerce.bicicle.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_address")
public class UserAddress {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "name")
    private String name;
    @Column(name = "lastnames")
    private String lastnames;
    @Column(name = "street")
    private String street;
    @Column(name = "int_number")
    private String intNumber;
    @Column(name = "ext_number")
    private String extNumber;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "state")
    private String state;
    @Column(name = "city")
    private String city;
    @Column(name = "suburb")
    private String suburb;
    @Column(name = "reference")
    private String reference;
    @Column(name = "phone_number")
    private String phoneNumber;

    public UserAddress() {
    }

    public int getId() {
        return id;
    }

    public UserAddress setId(int id) {
        this.id = id;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public UserAddress setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserAddress setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastnames() {
        return lastnames;
    }

    public UserAddress setLastnames(String lastnames) {
        this.lastnames = lastnames;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public UserAddress setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getIntNumber() {
        return intNumber;
    }

    public UserAddress setIntNumber(String intNumber) {
        this.intNumber = intNumber;
        return this;
    }

    public String getExtNumber() {
        return extNumber;
    }

    public UserAddress setExtNumber(String extNumber) {
        this.extNumber = extNumber;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public UserAddress setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getState() {
        return state;
    }

    public UserAddress setState(String state) {
        this.state = state;
        return this;
    }

    public String getCity() {
        return city;
    }

    public UserAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getSuburb() {
        return suburb;
    }

    public UserAddress setSuburb(String suburb) {
        this.suburb = suburb;
        return this;
    }

    public String getReference() {
        return reference;
    }

    public UserAddress setReference(String reference) {
        this.reference = reference;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserAddress setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
