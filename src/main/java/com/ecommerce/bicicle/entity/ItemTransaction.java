package com.ecommerce.bicicle.entity;

import javax.persistence.*;

@Entity
@Table(name = "item_transaction")
public class ItemTransaction {

    @Id
    private int id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id")
    private ItemEntity item;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_vendor_id")
    private UserEntity userVendor;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_buyer_id")
    private UserEntity userBuyer;

    private String transactionStatus;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "buyer_address_id")
    private UserAddress buyerAddress;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vendor_address_id")
    private UserAddress vendorAddress;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "total_payment")
    private String totalPayment;

    @Column(name = "tracking_number")
    private String trackingNumber;

    @Column(name = "rate")
    private int rate;

    public ItemTransaction() {
    }

    public int getId() {
        return id;
    }

    public ItemTransaction setId(int id) {
        this.id = id;
        return this;
    }

    public ItemEntity getItem() {
        return item;
    }

    public ItemTransaction setItem(ItemEntity item) {
        this.item = item;
        return this;
    }

    public UserEntity getUserVendor() {
        return userVendor;
    }

    public ItemTransaction setUserVendor(UserEntity userVendor) {
        this.userVendor = userVendor;
        return this;
    }

    public UserEntity getUserBuyer() {
        return userBuyer;
    }

    public ItemTransaction setUserBuyer(UserEntity userBuyer) {
        this.userBuyer = userBuyer;
        return this;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public ItemTransaction setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
        return this;
    }

    public UserAddress getBuyerAddress() {
        return buyerAddress;
    }

    public ItemTransaction setBuyerAddress(UserAddress buyerAddress) {
        this.buyerAddress = buyerAddress;
        return this;
    }

    public UserAddress getVendorAddress() {
        return vendorAddress;
    }

    public ItemTransaction setVendorAddress(UserAddress vendorAddress) {
        this.vendorAddress = vendorAddress;
        return this;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public ItemTransaction setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public String getTotalPayment() {
        return totalPayment;
    }

    public ItemTransaction setTotalPayment(String totalPayment) {
        this.totalPayment = totalPayment;
        return this;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public ItemTransaction setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
        return this;
    }

    public int getRate() {
        return rate;
    }

    public ItemTransaction setRate(int rate) {
        this.rate = rate;
        return this;
    }

}
