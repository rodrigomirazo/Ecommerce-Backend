package com.Eclothes.item.entity;

public class ItemEntity {

    private int itemId;
    private String description;
    private int userPublisherId;

    public ItemEntity() {
    }

    public int getItemId() {
        return itemId;
    }

    public ItemEntity setItemId(int itemId) {
        this.itemId = itemId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getUserPublisherId() {
        return userPublisherId;
    }

    public ItemEntity setUserPublisherId(int userPublisherId) {
        this.userPublisherId = userPublisherId;
        return this;
    }
}
