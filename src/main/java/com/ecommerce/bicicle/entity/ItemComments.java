package com.ecommerce.bicicle.entity;

import javax.persistence.*;

@Entity
@Table(name = "item_comments")
public class ItemComments {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id")
    private ItemEntity item;

    @Column(name = "comment")
    private String comment;

    public ItemComments() {
    }

    public int getId() {
        return id;
    }

    public ItemComments setId(int id) {
        this.id = id;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public ItemComments setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public ItemEntity getItem() {
        return item;
    }

    public ItemComments setItem(ItemEntity item) {
        this.item = item;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public ItemComments setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
