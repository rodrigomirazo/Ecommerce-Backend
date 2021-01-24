package com.ecommerce.bicicle.entity;

import javax.persistence.*;

@Entity
@Table(name = "item_transaction")
public class ItemTransactionEntity {

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
    private UserAddressEntity buyerAddress;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vendor_address_id")
    private UserAddressEntity vendorAddress;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "total_payment")
    private String totalPayment;

    @Column(name = "tracking_number")
    private String trackingNumber;

    @Column(name = "rate")
    private int rate;

    public ItemTransactionEntity() {
    }

    public int getId() {
        return id;
    }

    public ItemTransactionEntity setId(int id) {
        this.id = id;
        return this;
    }

    public ItemEntity getItem() {
        return item;
    }

    public ItemTransactionEntity setItem(ItemEntity item) {
        this.item = item;
        return this;
    }

    public UserEntity getUserVendor() {
        return userVendor;
    }

    public ItemTransactionEntity setUserVendor(UserEntity userVendor) {
        this.userVendor = userVendor;
        return this;
    }

    public UserEntity getUserBuyer() {
        return userBuyer;
    }

    public ItemTransactionEntity setUserBuyer(UserEntity userBuyer) {
        this.userBuyer = userBuyer;
        return this;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public ItemTransactionEntity setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
        return this;
    }

    public UserAddressEntity getBuyerAddress() {
        return buyerAddress;
    }

    public ItemTransactionEntity setBuyerAddress(UserAddressEntity buyerAddress) {
        this.buyerAddress = buyerAddress;
        return this;
    }

    public UserAddressEntity getVendorAddress() {
        return vendorAddress;
    }

    public ItemTransactionEntity setVendorAddress(UserAddressEntity vendorAddress) {
        this.vendorAddress = vendorAddress;
        return this;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public ItemTransactionEntity setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public String getTotalPayment() {
        return totalPayment;
    }

    public ItemTransactionEntity setTotalPayment(String totalPayment) {
        this.totalPayment = totalPayment;
        return this;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public ItemTransactionEntity setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
        return this;
    }

    public int getRate() {
        return rate;
    }

    public ItemTransactionEntity setRate(int rate) {
        this.rate = rate;
        return this;
    }

}
