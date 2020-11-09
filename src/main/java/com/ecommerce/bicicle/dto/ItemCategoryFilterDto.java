package com.ecommerce.bicicle.dto;

import com.ecommerce.bicicle.entity.ItemCategory;

import java.io.Serializable;
import java.util.List;

public class ItemCategoryFilterDto implements Serializable {

    private static final long serialVersionUID = -8011703154058010176L;
    private int id;
    private boolean isSelected;
    private int itemTypeId;
    private int subCategoryLevel;
    private Integer parentId;
    private String categoryName;
    private String subCategoryName;
    private String subCategoryNameEsp;

    // Recursion
    private List<ItemCategoryFilterDto> subCategories;

    public ItemCategoryFilterDto() {
    }

    public int getId() {
        return id;
    }

    public ItemCategoryFilterDto setId(int id) {
        this.id = id;
        return this;
    }

    public boolean getIsSelected() {
        return isSelected;
    }

    public ItemCategoryFilterDto setSelected(boolean selected) {
        isSelected = selected;
        return this;
    }

    public int getItemTypeId() {
        return itemTypeId;
    }

    public ItemCategoryFilterDto setItemTypeId(int itemTypeId) {
        this.itemTypeId = itemTypeId;
        return this;
    }

    public int getSubCategoryLevel() {
        return subCategoryLevel;
    }

    public ItemCategoryFilterDto setSubCategoryLevel(int subCategoryLevel) {
        this.subCategoryLevel = subCategoryLevel;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public ItemCategoryFilterDto setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public ItemCategoryFilterDto setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public ItemCategoryFilterDto setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
        return this;
    }

    public String getSubCategoryNameEsp() {
        return subCategoryNameEsp;
    }

    public ItemCategoryFilterDto setSubCategoryNameEsp(String subCategoryNameEsp) {
        this.subCategoryNameEsp = subCategoryNameEsp;
        return this;
    }

    public List<ItemCategoryFilterDto> getSubCategories() {
        return subCategories;
    }

    public ItemCategoryFilterDto setSubCategories(List<ItemCategoryFilterDto> subCategories) {
        this.subCategories = subCategories;
        return this;
    }
}
