package com.ecommerce.bicicle.dto;

import java.util.List;

public class FloatingCharsCatResponseDto {

    private int floatingCharsCatId;
    private int floatingCharsCatName;
    private List<FloatingCharsResponseDto> floatingCahrs;

    public FloatingCharsCatResponseDto() {
    }

    public int getFloatingCharsCatId() {
        return floatingCharsCatId;
    }

    public FloatingCharsCatResponseDto setFloatingCharsCatId(int floatingCharsCatId) {
        this.floatingCharsCatId = floatingCharsCatId;
        return this;
    }

    public int getFloatingCharsCatName() {
        return floatingCharsCatName;
    }

    public FloatingCharsCatResponseDto setFloatingCharsCatName(int floatingCharsCatName) {
        this.floatingCharsCatName = floatingCharsCatName;
        return this;
    }

    public List<FloatingCharsResponseDto> getFloatingCahrs() {
        return floatingCahrs;
    }

    public FloatingCharsCatResponseDto setFloatingCahrs(List<FloatingCharsResponseDto> floatingCahrs) {
        this.floatingCahrs = floatingCahrs;
        return this;
    }
}
