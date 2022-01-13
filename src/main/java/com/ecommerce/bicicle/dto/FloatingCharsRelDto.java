package com.ecommerce.bicicle.dto;

public class FloatingCharsRelDto {

    // ID for Floating Entity
    private int floatingCharId;
    private String floatingCharName;

    // ID for Floating value Entity
    private int floatingCharCatId;
    private String floatingCharCatName;


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

    public String getFloatingCharName() {
        return floatingCharName;
    }

    public FloatingCharsRelDto setFloatingCharName(String floatingCharName) {
        this.floatingCharName = floatingCharName;
        return this;
    }

    public String getFloatingCharCatName() {
        return floatingCharCatName;
    }

    public FloatingCharsRelDto setFloatingCharCatName(String floatingCharCatName) {
        this.floatingCharCatName = floatingCharCatName;
        return this;
    }
}
