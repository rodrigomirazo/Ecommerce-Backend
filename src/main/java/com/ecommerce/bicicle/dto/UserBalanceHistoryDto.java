package com.ecommerce.bicicle.dto;

import java.io.Serializable;

public class UserBalanceHistoryDto implements Serializable {

    private static final long serialVersionUID = -8479647237128169558L;
    private int id;
    private UserDto user;
    private ItemTransactionDto itemTransaction;
    private double totalPayment;

    public UserBalanceHistoryDto() {
    }

    public int getId() {
        return id;
    }

    public UserBalanceHistoryDto setId(int id) {
        this.id = id;
        return this;
    }

    public UserDto getUser() {
        return user;
    }

    public UserBalanceHistoryDto setUser(UserDto user) {
        this.user = user;
        return this;
    }

    public ItemTransactionDto getItemTransaction() {
        return itemTransaction;
    }

    public UserBalanceHistoryDto setItemTransaction(ItemTransactionDto itemTransaction) {
        this.itemTransaction = itemTransaction;
        return this;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public UserBalanceHistoryDto setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
        return this;
    }
}
