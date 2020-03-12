package com.Eclothes.item.entity;

import com.Eclothes.item.entity.catalogs.CharOriginEntity;

import java.util.List;

public class ItemCategoryEntity {

    private int id;
    private CharOriginEntity originEntity;
    private String name;
    private List<ItemCategorySubEntity> subCategories;

    public ItemCategoryEntity() {
    }

    public int getId() {
        return id;
    }

    public ItemCategoryEntity setId(int id) {
        this.id = id;
        return this;
    }

    public CharOriginEntity getOriginEntity() {
        return originEntity;
    }

    public ItemCategoryEntity setOriginEntity(CharOriginEntity originEntity) {
        this.originEntity = originEntity;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemCategoryEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<ItemCategorySubEntity> getSubCategories() {
        return subCategories;
    }

    public ItemCategoryEntity setSubCategories(List<ItemCategorySubEntity> subCategories) {
        this.subCategories = subCategories;
        return this;
    }
}
