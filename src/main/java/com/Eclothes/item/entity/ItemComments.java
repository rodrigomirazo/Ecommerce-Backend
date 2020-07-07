package com.Eclothes.item.entity;

import javax.persistence.*;

@Entity
@Table(name = "item_comments")
public class ItemComments {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id")
    private Item item;

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

    public User getUser() {
        return user;
    }

    public ItemComments setUser(User user) {
        this.user = user;
        return this;
    }

    public Item getItem() {
        return item;
    }

    public ItemComments setItem(Item item) {
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
