package com.ecommerce.bicicle.dto;

public class ItemFloatingCharsRelDto {

    private int itemFloatingCharsRelId;
    private int itemId;
    private int itemFloatingCharsCatId;

    public ItemFloatingCharsRelDto() {
    }

    public int getItemFloatingCharsRelId() {
        return itemFloatingCharsRelId;
    }

    public ItemFloatingCharsRelDto setItemFloatingCharsRelId(int itemFloatingCharsRelId) {
        this.itemFloatingCharsRelId = itemFloatingCharsRelId;
        return this;
    }

    public int getItemId() {
        return itemId;
    }

    public ItemFloatingCharsRelDto setItemId(int itemId) {
        this.itemId = itemId;
        return this;
    }

    public int getItemFloatingCharsCatId() {
        return itemFloatingCharsCatId;
    }

    public ItemFloatingCharsRelDto setItemFloatingCharsCatId(int itemFloatingCharsCatId) {
        this.itemFloatingCharsCatId = itemFloatingCharsCatId;
        return this;
    }
}
