package com.Eclothes.item.entity;

import java.util.List;

public class ItemCategorySubEntity {

    private int id;
    private String name;
    private List<ItemCategorySegmentEntity> segments;

    public ItemCategorySubEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemCategorySegmentEntity> getSegments() {
        return segments;
    }

    public void setSegments(List<ItemCategorySegmentEntity> segments) {
        this.segments = segments;
    }
}
