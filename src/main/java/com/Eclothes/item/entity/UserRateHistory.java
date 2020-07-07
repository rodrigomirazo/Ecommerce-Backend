package com.Eclothes.item.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_rate_history")
public class UserRateHistory {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transaction_id")
    private ItemTransaction itemTransaction;

    @Column(name = "rate")
    private int rate;

    public UserRateHistory() {
    }

    public int getId() {
        return id;
    }

    public UserRateHistory setId(int id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserRateHistory setUser(User user) {
        this.user = user;
        return this;
    }

    public ItemTransaction getItemTransaction() {
        return itemTransaction;
    }

    public UserRateHistory setItemTransaction(ItemTransaction itemTransaction) {
        this.itemTransaction = itemTransaction;
        return this;
    }

    public int getRate() {
        return rate;
    }

    public UserRateHistory setRate(int rate) {
        this.rate = rate;
        return this;
    }
}
