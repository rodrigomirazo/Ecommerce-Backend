package com.ecommerce.bicicle.dto;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class ItemTransactionDto implements Serializable {

    private static final long serialVersionUID = 8580770524812806057L;
    private int id;
    private ItemSavedDto item;
    private UserDto userVendor;
    private UserDto userBuyer;
    private String transactionStatus;
    private UserAddressDto buyerAddress;
    private UserAddressDto vendorAddress;
    private String paymentMethod;
    private String totalPayment;
    private String trackingNumber;
    private Integer rate;
    private List<ItemTransactionHistoryDto> itemTransactionHistory;
    private Timestamp createdTime;
    private boolean paymentConfirmed;

    private Boolean service;
    private Timestamp serviceTime;

    private Boolean sent;
    private Timestamp sentTime;

    private Boolean recieved;
    private Timestamp recievedTime;

    public ItemTransactionDto() {
    }
    //@JsonGetter("_id")
    public int getId() {
        return id;
    }

    public ItemTransactionDto setId(int id) {
        this.id = id;
        return this;
    }
    //@JsonGetter("_item")

    public ItemSavedDto getItem() {
        return item;
    }

    public ItemTransactionDto setItem(ItemSavedDto item) {
        this.item = item;
        return this;
    }

    //@JsonGetter("_userVendor")
    public UserDto getUserVendor() {
        return userVendor;
    }

    public ItemTransactionDto setUserVendor(UserDto userVendor) {
        this.userVendor = userVendor;
        return this;
    }
    //@JsonGetter("_userBuyer")
    public UserDto getUserBuyer() {
        return userBuyer;
    }

    public ItemTransactionDto setUserBuyer(UserDto userBuyer) {
        this.userBuyer = userBuyer;
        return this;
    }

    //@JsonGetter("_transactionStatus")
    public String getTransactionStatus() {
        return transactionStatus;
    }

    public ItemTransactionDto setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
        return this;
    }

    //@JsonGetter("_buyerAddress")
    public UserAddressDto getBuyerAddress() {
        return buyerAddress;
    }

    public ItemTransactionDto setBuyerAddress(UserAddressDto buyerAddress) {
        this.buyerAddress = buyerAddress;
        return this;
    }

    //@JsonGetter("_vendorAddress")
    public UserAddressDto getVendorAddress() {
        return vendorAddress;
    }

    public ItemTransactionDto setVendorAddress(UserAddressDto vendorAddress) {
        this.vendorAddress = vendorAddress;
        return this;
    }
    //@JsonGetter("_paymentMethod")
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public ItemTransactionDto setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }
    //@JsonGetter("_totalPayment")
    public String getTotalPayment() {
        return totalPayment;
    }

    public ItemTransactionDto setTotalPayment(String totalPayment) {
        this.totalPayment = totalPayment;
        return this;
    }
    //@JsonGetter("_trackingNumber")
    public String getTrackingNumber() {
        return trackingNumber;
    }

    public ItemTransactionDto setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
        return this;
    }
    //@JsonGetter("_rate")
    public Integer getRate() {
        return rate;
    }

    public ItemTransactionDto setRate(Integer rate) {
        this.rate = rate;
        return this;
    }
    //@JsonGetter("_itemTransactionHistory")
    public List<ItemTransactionHistoryDto> getItemTransactionHistory() {
        return itemTransactionHistory;
    }

    public ItemTransactionDto setItemTransactionHistory(List<ItemTransactionHistoryDto> itemTransactionHistory) {
        this.itemTransactionHistory = itemTransactionHistory;
        return this;
    }
    //@JsonGetter("_createdTime")
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public ItemTransactionDto setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public boolean isPaymentConfirmed() {
        return paymentConfirmed;
    }

    public ItemTransactionDto setPaymentConfirmed(boolean paymentConfirmed) {
        this.paymentConfirmed = paymentConfirmed;
        return this;
    }

    public Boolean getService() {
        return service;
    }

    public ItemTransactionDto setService(Boolean service) {
        this.service = service;
        return this;
    }

    public Timestamp getServiceTime() {
        return serviceTime;
    }

    public ItemTransactionDto setServiceTime(Timestamp serviceTime) {
        this.serviceTime = serviceTime;
        return this;
    }

    public Boolean getSent() {
        return sent;
    }

    public ItemTransactionDto setSent(Boolean sent) {
        this.sent = sent;
        return this;
    }

    public Timestamp getSentTime() {
        return sentTime;
    }

    public ItemTransactionDto setSentTime(Timestamp sentTime) {
        this.sentTime = sentTime;
        return this;
    }

    public Boolean getRecieved() {
        return recieved;
    }

    public ItemTransactionDto setRecieved(Boolean recieved) {
        this.recieved = recieved;
        return this;
    }

    public Timestamp getRecievedTime() {
        return recievedTime;
    }

    public ItemTransactionDto setRecievedTime(Timestamp recievedTime) {
        this.recievedTime = recievedTime;
        return this;
    }
}
