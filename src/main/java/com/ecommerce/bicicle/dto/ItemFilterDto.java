package com.ecommerce.bicicle.dto;

import java.util.List;

public class ItemFilterDto {

    private String searchBar;
    private List<Integer> years;
    private List<ItemFloatingCharsFilterDto> itemFloatingChars;
    private List<ItemCategoryFilterDto> itemTypes;

    public ItemFilterDto() {
    }

    public String getSearchBar() {
        return searchBar;
    }

    public ItemFilterDto setSearchBar(String searchBar) {
        this.searchBar = searchBar;
        return this;
    }

    public List<Integer> getYears() {
        return years;
    }

    public ItemFilterDto setYears(List<Integer> years) {
        this.years = years;
        return this;
    }

    public List<ItemFloatingCharsFilterDto> getItemFloatingChars() {
        return itemFloatingChars;
    }

    public ItemFilterDto setItemFloatingChars(List<ItemFloatingCharsFilterDto> itemFloatingChars) {
        this.itemFloatingChars = itemFloatingChars;
        return this;
    }

    public List<ItemCategoryFilterDto> getItemTypes() {
        return itemTypes;
    }

    public ItemFilterDto setItemTypes(List<ItemCategoryFilterDto> itemTypes) {
        this.itemTypes = itemTypes;
        return this;
    }
}
