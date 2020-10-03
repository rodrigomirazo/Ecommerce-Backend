package com.ecommerce.bicicle.dto;

import java.io.Serializable;

public class ItemCommentsDto implements Serializable {

    private static final long serialVersionUID = -2708060042349507592L;
    private int id;
    private UserDto user;
    private ItemDTo item;
    private String comment;

    public ItemCommentsDto() {
    }

    public int getId() {
        return id;
    }

    public ItemCommentsDto setId(int id) {
        this.id = id;
        return this;
    }

    public UserDto getUser() {
        return user;
    }

    public ItemCommentsDto setUser(UserDto user) {
        this.user = user;
        return this;
    }

    public ItemDTo getItem() {
        return item;
    }

    public ItemCommentsDto setItem(ItemDTo item) {
        this.item = item;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public ItemCommentsDto setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
