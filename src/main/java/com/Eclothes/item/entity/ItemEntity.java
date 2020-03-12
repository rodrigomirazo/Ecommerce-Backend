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

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserPublisherId() {
        return userPublisherId;
    }

    public void setUserPublisherId(int userPublisherId) {
        this.userPublisherId = userPublisherId;
    }
}
