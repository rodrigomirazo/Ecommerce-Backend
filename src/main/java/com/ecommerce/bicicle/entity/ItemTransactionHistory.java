package com.ecommerce.bicicle.entity;

import javax.persistence.*;

@Entity
@Table(name = "item_transaction")
public class ItemTransactionHistory {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transaction_id")
    private ItemTransaction itemTransaction;

    @Column(name = "action")
    private String action;

    @Column(name = "description")
    private String description;

    public ItemTransactionHistory() {
    }

    public int getId() {
        return id;
    }

    public ItemTransactionHistory setId(int id) {
        this.id = id;
        return this;
    }

    public ItemTransaction getItemTransaction() {
        return itemTransaction;
    }

    public ItemTransactionHistory setItemTransaction(ItemTransaction itemTransaction) {
        this.itemTransaction = itemTransaction;
        return this;
    }

    public String getAction() {
        return action;
    }

    public ItemTransactionHistory setAction(String action) {
        this.action = action;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemTransactionHistory setDescription(String description) {
        this.description = description;
        return this;
    }
}
