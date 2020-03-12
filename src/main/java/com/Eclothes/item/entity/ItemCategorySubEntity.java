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

    public ItemCategorySubEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemCategorySubEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<ItemCategorySegmentEntity> getSegments() {
        return segments;
    }

    public ItemCategorySubEntity setSegments(List<ItemCategorySegmentEntity> segments) {
        this.segments = segments;
        return this;
    }
}
