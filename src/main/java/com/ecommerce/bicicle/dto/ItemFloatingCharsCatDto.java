package com.ecommerce.bicicle.dto;

public class ItemFloatingCharsCatDto {

    private int floatingCharCatId;
    private String floatingCharName;
    private ItemFloatingCharsDto itemFloatingChar;

    public ItemFloatingCharsCatDto() {
    }

    public int getFloatingCharCatId() {
        return floatingCharCatId;
    }

    public ItemFloatingCharsCatDto setFloatingCharCatId(int floatingCharCatId) {
        this.floatingCharCatId = floatingCharCatId;
        return this;
    }

    public ItemFloatingCharsDto getItemFloatingChar() {
        return itemFloatingChar;
    }

    public ItemFloatingCharsCatDto setItemFloatingChar(ItemFloatingCharsDto itemFloatingChar) {
        this.itemFloatingChar = itemFloatingChar;
        return this;
    }

    public String getFloatingCharName() {
        return floatingCharName;
    }

    public ItemFloatingCharsCatDto setFloatingCharName(String floatingCharName) {
        this.floatingCharName = floatingCharName;
        return this;
    }
}
