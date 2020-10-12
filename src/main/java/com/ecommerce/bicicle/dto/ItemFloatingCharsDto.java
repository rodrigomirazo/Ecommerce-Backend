package com.ecommerce.bicicle.dto;

import java.util.List;

public class ItemFloatingCharsDto {

    private int floatingCharId;
    private String floatingCharName;
    private List<ItemFloatingCharsCatDto> catalogList;

    public ItemFloatingCharsDto() {
    }

    public int getFloatingCharId() {
        return floatingCharId;
    }

    public ItemFloatingCharsDto setFloatingCharId(int floatingCharId) {
        this.floatingCharId = floatingCharId;
        return this;
    }

    public String getFloatingCharName() {
        return floatingCharName;
    }

    public ItemFloatingCharsDto setFloatingCharName(String floatingCharName) {
        this.floatingCharName = floatingCharName;
        return this;
    }

    public List<ItemFloatingCharsCatDto> getCatalogList() {
        return catalogList;
    }

    public ItemFloatingCharsDto setCatalogList(List<ItemFloatingCharsCatDto> catalogList) {
        this.catalogList = catalogList;
        return this;
    }
}
