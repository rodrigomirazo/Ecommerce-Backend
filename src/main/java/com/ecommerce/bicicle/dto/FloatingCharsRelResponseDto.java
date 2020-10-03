package com.ecommerce.bicicle.dto;

public class FloatingCharsRelResponseDto {

    private int itemFloatingCharsRelId;
    private int itemId;
    private int itemFloatingCharsCatId;
    private FloatingCharsCatResponseDto floatingCharsCatResponseDto;

    public FloatingCharsRelResponseDto() {
    }

    public int getItemFloatingCharsRelId() {
        return itemFloatingCharsRelId;
    }

    public FloatingCharsRelResponseDto setItemFloatingCharsRelId(int itemFloatingCharsRelId) {
        this.itemFloatingCharsRelId = itemFloatingCharsRelId;
        return this;
    }

    public int getItemId() {
        return itemId;
    }

    public FloatingCharsRelResponseDto setItemId(int itemId) {
        this.itemId = itemId;
        return this;
    }

    public int getItemFloatingCharsCatId() {
        return itemFloatingCharsCatId;
    }

    public FloatingCharsRelResponseDto setItemFloatingCharsCatId(int itemFloatingCharsCatId) {
        this.itemFloatingCharsCatId = itemFloatingCharsCatId;
        return this;
    }

    public FloatingCharsCatResponseDto getFloatingCharsCatResponseDto() {
        return floatingCharsCatResponseDto;
    }

    public FloatingCharsRelResponseDto setFloatingCharsCatResponseDto(FloatingCharsCatResponseDto floatingCharsCatResponseDto) {
        this.floatingCharsCatResponseDto = floatingCharsCatResponseDto;
        return this;
    }
}
