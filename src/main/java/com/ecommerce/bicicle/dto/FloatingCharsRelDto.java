package com.ecommerce.bicicle.dto;

public class FloatingCharsRelDto {

    // ID for Floating Entity
    private int floatingCharId;

    // ID for Floating value Entity
    private int floatingCharCatId;


    public FloatingCharsRelDto() {
    }

    public int getFloatingCharId() {
        return floatingCharId;
    }

    public FloatingCharsRelDto setFloatingCharId(int floatingCharId) {
        this.floatingCharId = floatingCharId;
        return this;
    }

    public int getFloatingCharCatId() {
        return floatingCharCatId;
    }

    public FloatingCharsRelDto setFloatingCharCatId(int floatingCharCatId) {
        this.floatingCharCatId = floatingCharCatId;
        return this;
    }

}
