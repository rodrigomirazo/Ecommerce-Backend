package com.ecommerce.bicicle.dto;

public class ItemFloatingCharsRelDto {

    private int itemFloatingCharsRelId;
    private int itemId;
    private int floatingCharCatId;
    private int floatingCharId;

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

    public int getFloatingCharCatId() {
        return floatingCharCatId;
    }

    public ItemFloatingCharsRelDto setFloatingCharCatId(int floatingCharCatId) {
        this.floatingCharCatId = floatingCharCatId;
        return this;
    }

    public int getFloatingCharId() {
        return floatingCharId;
    }

    public ItemFloatingCharsRelDto setFloatingCharId(int floatingCharId) {
        this.floatingCharId = floatingCharId;
        return this;
    }
}
