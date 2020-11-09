package com.ecommerce.bicicle.dto;

import java.util.List;

public class ItemFloatingCharsFilterDto {

    private Integer floatingCharId;
    private String floatingCharName;
    private List<ItemFloatingCharsCatFilterDto> catalogList;

    public ItemFloatingCharsFilterDto() {
    }

    public Integer getFloatingCharId() {
        return floatingCharId;
    }

    public ItemFloatingCharsFilterDto setFloatingCharId(Integer floatingCharId) {
        this.floatingCharId = floatingCharId;
        return this;
    }

    public String getFloatingCharName() {
        return floatingCharName;
    }

    public ItemFloatingCharsFilterDto setFloatingCharName(String floatingCharName) {
        this.floatingCharName = floatingCharName;
        return this;
    }

    public List<ItemFloatingCharsCatFilterDto> getCatalogList() {
        return catalogList;
    }

    public ItemFloatingCharsFilterDto setCatalogList(List<ItemFloatingCharsCatFilterDto> catalogList) {
        this.catalogList = catalogList;
        return this;
    }
}
