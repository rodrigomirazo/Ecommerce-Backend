package com.Eclothes.item.dto;

import com.Eclothes.item.entity.ItemCategory;
import com.Eclothes.item.entity.ItemTypeCat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class ItemCategoryDto implements Serializable {

    private static final long serialVersionUID = -8011703154058010176L;
    private int id;
    private int itemTypeId;
    private int subCategoryLevel;
    private Integer parentId;
    private String categoryName;
    private String subCategoryName;
    private String subCategoryNameEsp;

    // Recursion
    private List<ItemCategoryDto> subCategories;

    public ItemCategoryDto() {
    }

    public ItemCategoryDto(ItemCategory itemCategory, int parentId) {

        itemCategory.getItemTypeCat();

        this.setId( itemCategory.getId() );
        this.setItemTypeId( itemCategory.getItemTypeCat().getId() );
        this.setSubCategoryLevel( itemCategory.getSubCategoryLevel() );
        this.setParentId( parentId );
        this.setCategoryName( itemCategory.getCategoryName() );
        this.setSubCategoryName( itemCategory.getSubCategoryName() );
        this.setSubCategoryNameEsp( itemCategory.getSubCategoryNameEsp() );
    }

    public ItemCategoryDto(ItemCategory itemCategory) {

        itemCategory.getItemTypeCat();

        this.setId( itemCategory.getId() );
        this.setItemTypeId( itemCategory.getItemTypeCat().getId() );
        this.setSubCategoryLevel( itemCategory.getSubCategoryLevel() );
        this.setParentId( itemCategory.getParentId() );
        this.setCategoryName( itemCategory.getCategoryName() );
        this.setSubCategoryName( itemCategory.getSubCategoryName() );
        this.setSubCategoryNameEsp( itemCategory.getSubCategoryNameEsp() );
    }

    public int getId() {
        return id;
    }

    public ItemCategoryDto setId(int id) {
        this.id = id;
        return this;
    }

    public int getItemTypeId() {
        return itemTypeId;
    }

    public ItemCategoryDto setItemTypeId(int itemTypeId) {
        this.itemTypeId = itemTypeId;
        return this;
    }

    public int getSubCategoryLevel() {
        return subCategoryLevel;
    }

    public ItemCategoryDto setSubCategoryLevel(int subCategoryLevel) {
        this.subCategoryLevel = subCategoryLevel;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public ItemCategoryDto setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public ItemCategoryDto setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public ItemCategoryDto setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
        return this;
    }

    public String getSubCategoryNameEsp() {
        return subCategoryNameEsp;
    }

    public ItemCategoryDto setSubCategoryNameEsp(String subCategoryNameEsp) {
        this.subCategoryNameEsp = subCategoryNameEsp;
        return this;
    }

    public List<ItemCategoryDto> getSubCategories() {
        return subCategories;
    }

    public ItemCategoryDto setSubCategories(List<ItemCategoryDto> subCategories) {
        this.subCategories = subCategories;
        return this;
    }
}
