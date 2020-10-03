package com.ecommerce.bicicle.dto;

public class FloatingCharsResponseDto {

    private int floatingCharId;
    private int charName;

    public FloatingCharsResponseDto() {
    }

    public int getFloatingCharId() {
        return floatingCharId;
    }

    public FloatingCharsResponseDto setFloatingCharId(int floatingCharId) {
        this.floatingCharId = floatingCharId;
        return this;
    }

    public int getCharName() {
        return charName;
    }

    public FloatingCharsResponseDto setCharName(int charName) {
        this.charName = charName;
        return this;
    }
}
