package com.ecommerce.bicicle.dto;

import java.io.Serializable;

public class UserRateHistoryDto implements Serializable {

    private static final long serialVersionUID = 251604516544409918L;
    private int id;
    private UserDto user;
    private ItemTransactionDto itemTransaction;
    private int rate;

    public UserRateHistoryDto() {
    }

    public int getId() {
        return id;
    }

    public UserRateHistoryDto setId(int id) {
        this.id = id;
        return this;
    }

    public UserDto getUser() {
        return user;
    }

    public UserRateHistoryDto setUser(UserDto user) {
        this.user = user;
        return this;
    }

    public ItemTransactionDto getItemTransaction() {
        return itemTransaction;
    }

    public UserRateHistoryDto setItemTransaction(ItemTransactionDto itemTransaction) {
        this.itemTransaction = itemTransaction;
        return this;
    }

    public int getRate() {
        return rate;
    }

    public UserRateHistoryDto setRate(int rate) {
        this.rate = rate;
        return this;
    }
}
