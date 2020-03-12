package com.Eclothes.item.entity;

import java.util.List;

public class ItemCategoryEntity {

    private int id;
    private String name;
    private List<ItemCategorySubEntity> subCategories;

    public ItemCategoryEntity() {
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

    public List<ItemCategorySubEntity> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<ItemCategorySubEntity> subCategories) {
        this.subCategories = subCategories;
    }
}
