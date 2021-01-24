package com.ecommerce.bicicle.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_rate_history")
public class UserRateHistory {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transaction_id")
    private ItemTransactionEntity itemTransaction;

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

    public UserEntity getUser() {
        return user;
    }

    public UserRateHistory setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public ItemTransactionEntity getItemTransaction() {
        return itemTransaction;
    }

    public UserRateHistory setItemTransaction(ItemTransactionEntity itemTransaction) {
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
