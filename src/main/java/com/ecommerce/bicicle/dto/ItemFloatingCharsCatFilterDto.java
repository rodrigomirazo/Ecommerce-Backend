package com.ecommerce.bicicle.dto;

public class ItemFloatingCharsCatFilterDto {

    private Integer charId;
    private String charName;
    private boolean isSelected;

    public ItemFloatingCharsCatFilterDto() {
    }

    public Integer getCharId() {
        return charId;
    }

    public ItemFloatingCharsCatFilterDto setCharId(Integer charId) {
        this.charId = charId;
        return this;
    }

    public String getCharName() {
        return charName;
    }

    public ItemFloatingCharsCatFilterDto setCharName(String charName) {
        this.charName = charName;
        return this;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public ItemFloatingCharsCatFilterDto setSelected(boolean selected) {
        isSelected = selected;
        return this;
    }
}
