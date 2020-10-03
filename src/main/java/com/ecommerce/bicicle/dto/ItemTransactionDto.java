package com.ecommerce.bicicle.dto;

import java.io.Serializable;

public class ItemTransactionDto implements Serializable {

    private static final long serialVersionUID = 1474610357147019047L;
    private int id;
    private ItemDTo item;
    private UserDto userVendor;
    private UserDto userBuyer;
    private String transactionStatus;
    private UserAddressDto buyerAddress;
    private UserAddressDto vendorAddress;
    private String paymentMethod;
    private String totalPayment;
    private String trackingNumber;
    private int rate;

    public ItemTransactionDto() {
    }

    public int getId() {
        return id;
    }

    public ItemTransactionDto setId(int id) {
        this.id = id;
        return this;
    }

    public ItemDTo getItem() {
        return item;
    }

    public ItemTransactionDto setItem(ItemDTo item) {
        this.item = item;
        return this;
    }

    public UserDto getUserVendor() {
        return userVendor;
    }

    public ItemTransactionDto setUserVendor(UserDto userVendor) {
        this.userVendor = userVendor;
        return this;
    }

    public UserDto getUserBuyer() {
        return userBuyer;
    }

    public ItemTransactionDto setUserBuyer(UserDto userBuyer) {
        this.userBuyer = userBuyer;
        return this;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public ItemTransactionDto setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
        return this;
    }

    public UserAddressDto getBuyerAddress() {
        return buyerAddress;
    }

    public ItemTransactionDto setBuyerAddress(UserAddressDto buyerAddress) {
        this.buyerAddress = buyerAddress;
        return this;
    }

    public UserAddressDto getVendorAddress() {
        return vendorAddress;
    }

    public ItemTransactionDto setVendorAddress(UserAddressDto vendorAddress) {
        this.vendorAddress = vendorAddress;
        return this;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public ItemTransactionDto setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public String getTotalPayment() {
        return totalPayment;
    }

    public ItemTransactionDto setTotalPayment(String totalPayment) {
        this.totalPayment = totalPayment;
        return this;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public ItemTransactionDto setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
        return this;
    }

    public int getRate() {
        return rate;
    }

    public ItemTransactionDto setRate(int rate) {
        this.rate = rate;
        return this;
    }

}
