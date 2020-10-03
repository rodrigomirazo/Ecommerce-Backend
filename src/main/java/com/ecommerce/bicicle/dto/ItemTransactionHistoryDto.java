package com.ecommerce.bicicle.dto;

import java.io.Serializable;

public class ItemTransactionHistoryDto implements Serializable {

    private static final long serialVersionUID = -1703022289240174602L;
    private int id;
    private ItemTransactionDto itemTransaction;
    private String action;
    private String description;

    public ItemTransactionHistoryDto() {
    }

    public int getId() {
        return id;
    }

    public ItemTransactionHistoryDto setId(int id) {
        this.id = id;
        return this;
    }

    public ItemTransactionDto getItemTransaction() {
        return itemTransaction;
    }

    public ItemTransactionHistoryDto setItemTransaction(ItemTransactionDto itemTransaction) {
        this.itemTransaction = itemTransaction;
        return this;
    }

    public String getAction() {
        return action;
    }

    public ItemTransactionHistoryDto setAction(String action) {
        this.action = action;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemTransactionHistoryDto setDescription(String description) {
        this.description = description;
        return this;
    }
}
