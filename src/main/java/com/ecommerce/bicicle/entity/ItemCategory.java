package com.ecommerce.bicicle.entity;

import com.ecommerce.bicicle.dto.ItemCategoryDto;
import javax.persistence.*;

@Entity
@Table(name = "item_category")
public class ItemCategory {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "item_type_id")
    private int itemTypeId;

    @Column(name = "sub_cat_level")
    private int subCategoryLevel;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "cat_name")
    private String categoryName;

    @Column(name = "sub_cat_name")
    private String subCategoryName;

    @Column(name = "sub_cat_name_esp")
    private String subCategoryNameEsp;

    public ItemCategory() {
    }

    public ItemCategory(ItemCategoryDto itemCategoryDto) {
        this.setSubCategoryLevel(itemCategoryDto.getSubCategoryLevel());
        this.setCategoryName(itemCategoryDto.getCategoryName());
        this.setSubCategoryName(itemCategoryDto.getSubCategoryName());
    }

    public int getId() {
        return id;
    }

    public ItemCategory setId(int id) {
        this.id = id;
        return this;
    }

    public int getSubCategoryLevel() {
        return subCategoryLevel;
    }

    public ItemCategory setSubCategoryLevel(int subCategoryLevel) {
        this.subCategoryLevel = subCategoryLevel;
        return this;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public ItemCategory setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public ItemCategory setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
        return this;
    }

    public int getItemTypeId() {
        return itemTypeId;
    }

    public ItemCategory setItemTypeId(int itemTypeId) {
        this.itemTypeId = itemTypeId;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public ItemCategory setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getSubCategoryNameEsp() {
        return subCategoryNameEsp;
    }

    public ItemCategory setSubCategoryNameEsp(String subCategoryNameEsp) {
        this.subCategoryNameEsp = subCategoryNameEsp;
        return this;
    }
}
