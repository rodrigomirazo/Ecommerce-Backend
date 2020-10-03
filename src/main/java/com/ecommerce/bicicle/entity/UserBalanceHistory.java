package com.ecommerce.bicicle.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_balance_history")
public class UserBalanceHistory {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transaction_id")
    private ItemTransaction itemTransaction;

    @Column(name = "total_payment")
    private double totalPayment;

    public UserBalanceHistory() {
    }

    public int getId() {
        return id;
    }

    public UserBalanceHistory setId(int id) {
        this.id = id;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public UserBalanceHistory setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public ItemTransaction getItemTransaction() {
        return itemTransaction;
    }

    public UserBalanceHistory setItemTransaction(ItemTransaction itemTransaction) {
        this.itemTransaction = itemTransaction;
        return this;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public UserBalanceHistory setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
        return this;
    }
}
