package com.ecommerce.bicicle.dto;

import java.util.List;

public class ItemFilterYearsDto {

    private Integer year;
    private boolean isSelected;

    public ItemFilterYearsDto() {
    }

    public Integer getYear() {
        return year;
    }

    public ItemFilterYearsDto setYear(Integer year) {
        this.year = year;
        return this;
    }

    public boolean getIsSelected() {
        return isSelected;
    }

    public ItemFilterYearsDto setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
        return this;
    }
}
