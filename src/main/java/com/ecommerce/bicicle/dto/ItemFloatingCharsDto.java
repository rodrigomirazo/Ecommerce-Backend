package com.ecommerce.bicicle.dto;

public class ItemFloatingCharsDto {

    private int floatingCharId;
    private String charName;

    public ItemFloatingCharsDto() {
    }

    public int getFloatingCharId() {
        return floatingCharId;
    }

    public ItemFloatingCharsDto setFloatingCharId(int floatingCharId) {
        this.floatingCharId = floatingCharId;
        return this;
    }

    public String getCharName() {
        return charName;
    }

    public ItemFloatingCharsDto setCharName(String charName) {
        this.charName = charName;
        return this;
    }
}
