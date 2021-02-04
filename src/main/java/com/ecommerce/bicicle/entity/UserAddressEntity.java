package com.ecommerce.bicicle.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_address")
public class UserAddressEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private String userId;
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
    @Column(name = "saved_in_profile")
    private boolean savedInProfile;
    @Column(name = "street_ref")
    private String streetRef;

    public UserAddressEntity() {
    }

    public int getId() {
        return id;
    }

    public UserAddressEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public UserAddressEntity setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserAddressEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastnames() {
        return lastnames;
    }

    public UserAddressEntity setLastnames(String lastnames) {
        this.lastnames = lastnames;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public UserAddressEntity setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getIntNumber() {
        return intNumber;
    }

    public UserAddressEntity setIntNumber(String intNumber) {
        this.intNumber = intNumber;
        return this;
    }

    public String getExtNumber() {
        return extNumber;
    }

    public UserAddressEntity setExtNumber(String extNumber) {
        this.extNumber = extNumber;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public UserAddressEntity setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getState() {
        return state;
    }

    public UserAddressEntity setState(String state) {
        this.state = state;
        return this;
    }

    public String getCity() {
        return city;
    }

    public UserAddressEntity setCity(String city) {
        this.city = city;
        return this;
    }

    public String getSuburb() {
        return suburb;
    }

    public UserAddressEntity setSuburb(String suburb) {
        this.suburb = suburb;
        return this;
    }

    public String getReference() {
        return reference;
    }

    public UserAddressEntity setReference(String reference) {
        this.reference = reference;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserAddressEntity setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public boolean isSavedInProfile() {
        return savedInProfile;
    }

    public UserAddressEntity setSavedInProfile(boolean savedInProfile) {
        this.savedInProfile = savedInProfile;
        return this;
    }

    public String getStreetRef() {
        return streetRef;
    }

    public UserAddressEntity setStreetRef(String streetRef) {
        this.streetRef = streetRef;
        return this;
    }
}
