package com.ecommerce.bicicle.dto;

public class ItemFloatingCharsCatDto {

    private int charId;
    private String charName;

    public ItemFloatingCharsCatDto() {
    }

    public int getCharId() {
        return charId;
    }

    public ItemFloatingCharsCatDto setCharId(int charId) {
        this.charId = charId;
        return this;
    }

    public String getCharName() {
        return charName;
    }

    public ItemFloatingCharsCatDto setCharName(String charName) {
        this.charName = charName;
        return this;
    }

    @Override
    public String toString() {
        return "ItemFloatingCharsCatDto{" +
                "charId=" + charId +
                ", charName='" + charName + '\'' +
                '}';
    }
}
