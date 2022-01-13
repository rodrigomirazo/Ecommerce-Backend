package com.ecommerce.bicicle.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class ItemTransactionHistoryDto implements Serializable {

    private static final long serialVersionUID = -1703022289240174602L;
    private int id;
    private Integer itemTransactionId;
    private String action;
    private String description;
    private Timestamp createdTime;

    public ItemTransactionHistoryDto() {
    }

    public int getId() {
        return id;
    }

    public ItemTransactionHistoryDto setId(int id) {
        this.id = id;
        return this;
    }

    public Integer getItemTransactionId() {
        return itemTransactionId;
    }

    public ItemTransactionHistoryDto setItemTransactionId(Integer itemTransactionId) {
        this.itemTransactionId = itemTransactionId;
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

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public ItemTransactionHistoryDto setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
        return this;
    }
}
