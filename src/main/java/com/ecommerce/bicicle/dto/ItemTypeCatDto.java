package com.ecommerce.bicicle.dto;

import com.ecommerce.bicicle.entity.ItemTypeCat;

import java.io.Serializable;
import java.util.List;

public class ItemTypeCatDto implements Serializable {

    private static final long serialVersionUID = -8704318866529678462L;
    private Integer id;
    private int itemTypeId;
    private int subCategoryLevel;
    private Integer parentId;
    private String categoryName;
    private String subCategoryName;
    private String subCategoryNameEsp;

    private List<ItemCategoryDto> itemCategoryDtos;

    public ItemTypeCatDto() {
    }

    public ItemTypeCatDto(ItemTypeCat itemTypeCat) {
        this.setId(itemTypeCat.getId());
        this.setCategoryName(itemTypeCat.getName());
        this.setItemTypeId(itemTypeCat.getId());
        this.setParentId(-1);
        this.setSubCategoryLevel(-1);
        this.setSubCategoryName("type");
        this.setSubCategoryNameEsp("tipo");

        /*
        // 1. Map categories
        List<ItemCategoryDto> allCategories = itemTypeCat.getItemCategories().stream().map(itemCategory -> new ItemCategoryDto(itemCategory, itemTypeCat.getId())).collect(Collectors.toList());

        // 2. get Type
        int itemType = this.getId();

        // 3. Filter by ItemType
        List<ItemCategoryDto> mainCategories =
            allCategories.stream().filter(itemCat -> itemCat.getItemTypeId() == itemType && itemCat.getParentId() == null).collect(Collectors.toList());

        //Result:
        int categoryIndex = 0;
        List<ItemCategoryDto> recursiveCat = new ArrayList<>();
        mainCategories.forEach(mainCategory -> {

            List<ItemCategoryDto> subCategories =
                allCategories.stream().filter(subCatgory -> subCatgory.getParentId() != null && subCatgory.getParentId() == mainCategory.getId()).collect(Collectors.toList());

            mainCategory.setSubCategories(subCategories);

            recursiveCat.add(mainCategory);

        });

        this.setSubCategories(recursiveCat);
        */
    }

    public Integer getId() {
        return id;
    }

    public ItemTypeCatDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public int getItemTypeId() {
        return itemTypeId;
    }

    public ItemTypeCatDto setItemTypeId(int itemTypeId) {
        this.itemTypeId = itemTypeId;
        return this;
    }

    public int getSubCategoryLevel() {
        return subCategoryLevel;
    }

    public ItemTypeCatDto setSubCategoryLevel(int subCategoryLevel) {
        this.subCategoryLevel = subCategoryLevel;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public ItemTypeCatDto setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public ItemTypeCatDto setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public ItemTypeCatDto setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
        return this;
    }

    public String getSubCategoryNameEsp() {
        return subCategoryNameEsp;
    }

    public ItemTypeCatDto setSubCategoryNameEsp(String subCategoryNameEsp) {
        this.subCategoryNameEsp = subCategoryNameEsp;
        return this;
    }

    public List<ItemCategoryDto> getItemCategoryDtos() {
        return itemCategoryDtos;
    }

    public ItemTypeCatDto setItemCategoryDtos(List<ItemCategoryDto> itemCategoryDtos) {
        this.itemCategoryDtos = itemCategoryDtos;
        return this;
    }
}
