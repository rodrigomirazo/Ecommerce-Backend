package com.ecommerce.bicicle.dto;

import com.ecommerce.bicicle.entity.ItemEntity;

import java.io.Serializable;
import java.util.List;

public class ItemSavedDto implements Serializable {

    private static final long serialVersionUID = -8236904528220098035L;
    private Integer id;
    private int statusId;
    private int itemColorId;
    private int itemTypeCatId;
    private int itemTransactionId;
    private String name;
    private Integer year;
    private long price;
    private long originalPrice;
    private double discount;
    private String description;
    private double fleetCost;
    private String sizeId;
    private int lastLevelCategoryId;
    private UserDto user;
    private List<ItemFloatingCharsRelDto> itemFloatingChars;

    public ItemSavedDto() { }

    public ItemSavedDto(ItemEntity item) {
        this.setId( item.getId() );
        this.setStatusId( item.getStatusId() );
        this.setItemColorId( item.getItemColorId() );
        this.setItemTypeCatId( item.getItemTypeCatId() );
        this.setItemTransactionId( item.getItemTransactionId() );
        this.setName( item.getName() );
        this.setYear( item.getYear() );
        this.setPrice( item.getPrice() );
        this.setOriginalPrice( item.getOriginalPrice() );
        this.setDiscount( item.getDiscount() );
        this.setDescription( item.getDescription() );
        this.setFleetCost( item.getFleetCost() );
        this.setSizeId( item.getSizeId() );
        this.setLastLevelCategoryId( item.getLastLevelCategoryId() );
    }

    public ItemSavedDto(ItemEntity item, List<ItemFloatingCharsRelDto> itemFloatingCharsRelDtoList) {
        this.setId( item.getId() );
        this.setStatusId( item.getStatusId() );
        this.setItemColorId( item.getItemColorId() );
        this.setItemTypeCatId( item.getItemTypeCatId() );
        this.setItemTransactionId( item.getItemTransactionId() );
        this.setName( item.getName() );
        this.setYear( item.getYear() );
        this.setPrice( item.getPrice() );
        this.setOriginalPrice( item.getOriginalPrice() );
        this.setDiscount( item.getDiscount() );
        this.setDescription( item.getDescription() );
        this.setFleetCost( item.getFleetCost() );
        this.setSizeId( item.getSizeId() );
        this.setLastLevelCategoryId( item.getLastLevelCategoryId() );
        this.setItemFloatingChars(itemFloatingCharsRelDtoList);
    }

    public Integer getId() {
        return id;
    }

    public ItemSavedDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public int getStatusId() {
        return statusId;
    }

    public ItemSavedDto setStatusId(int statusId) {
        this.statusId = statusId;
        return this;
    }

    public int getItemColorId() {
        return itemColorId;
    }

    public ItemSavedDto setItemColorId(int itemColorId) {
        this.itemColorId = itemColorId;
        return this;
    }

    public int getItemTypeCatId() {
        return itemTypeCatId;
    }

    public ItemSavedDto setItemTypeCatId(int itemTypeCatId) {
        this.itemTypeCatId = itemTypeCatId;
        return this;
    }

    public int getItemTransactionId() {
        return itemTransactionId;
    }

    public ItemSavedDto setItemTransactionId(int itemTransactionId) {
        this.itemTransactionId = itemTransactionId;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemSavedDto setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public ItemSavedDto setYear(Integer year) {
        this.year = year;
        return this;
    }

    public long getPrice() {
        return price;
    }

    public ItemSavedDto setPrice(long price) {
        this.price = price;
        return this;
    }

    public long getOriginalPrice() {
        return originalPrice;
    }

    public ItemSavedDto setOriginalPrice(long originalPrice) {
        this.originalPrice = originalPrice;
        return this;
    }

    public double getDiscount() {
        return discount;
    }

    public ItemSavedDto setDiscount(double discount) {
        this.discount = discount;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemSavedDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getFleetCost() {
        return fleetCost;
    }

    public ItemSavedDto setFleetCost(double fleetCost) {
        this.fleetCost = fleetCost;
        return this;
    }

    public String getSizeId() {
        return sizeId;
    }

    public ItemSavedDto setSizeId(String sizeId) {
        this.sizeId = sizeId;
        return this;
    }

    public int getLastLevelCategoryId() {
        return lastLevelCategoryId;
    }

    public ItemSavedDto setLastLevelCategoryId(int lastLevelCategoryId) {
        this.lastLevelCategoryId = lastLevelCategoryId;
        return this;
    }

    public UserDto getUser() {
        return user;
    }

    public ItemSavedDto setUser(UserDto user) {
        this.user = user;
        return this;
    }

    public List<ItemFloatingCharsRelDto> getItemFloatingChars() {
        return itemFloatingChars;
    }

    public ItemSavedDto setItemFloatingChars(List<ItemFloatingCharsRelDto> itemFloatingChars) {
        this.itemFloatingChars = itemFloatingChars;
        return this;
    }
}
