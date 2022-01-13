package com.ecommerce.bicicle.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "item_transaction_history")
public class ItemTransactionHistoryEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "transaction_id")
    private Integer itemTransactionId;

    @Column(name = "action")
    private String action;

    @Column(name = "description")
    private String description;

    @Column(name = "created_time")
    private Timestamp createdTime;

    public ItemTransactionHistoryEntity() {
    }

    public int getId() {
        return id;
    }

    public ItemTransactionHistoryEntity setId(int id) {
        this.id = id;
        return this;
    }

    public Integer getItemTransactionId() {
        return itemTransactionId;
    }

    public ItemTransactionHistoryEntity setItemTransactionId(Integer itemTransactionId) {
        this.itemTransactionId = itemTransactionId;
        return this;
    }

    public String getAction() {
        return action;
    }

    public ItemTransactionHistoryEntity setAction(String action) {
        this.action = action;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemTransactionHistoryEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public ItemTransactionHistoryEntity setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
        return this;
    }
}
