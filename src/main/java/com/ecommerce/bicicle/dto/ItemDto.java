package com.ecommerce.bicicle.dto;

import com.ecommerce.bicicle.entity.ItemEntity;

import java.io.Serializable;

public class ItemDto implements Serializable {

    private static final long serialVersionUID = -8236904528220098035L;
    private String id;
    private int statusId;
    private int itemColorId;
    private int itemTypeCatId;
    private int itemTransactionId;
    private String name;
    private long price;
    private long originalPrice;
    private double discount;
    private String description;
    private double fleetCost;
    private String sizeId;
    private int lastLevelCategoryId;
    private UserDto user;

    public ItemDto() { }

    public ItemDto(ItemEntity item) {
        this.setId( item.getId() );
        this.setStatusId( item.getStatusId() );
        this.setItemColorId( item.getItemColorId() );
        this.setItemTypeCatId( item.getItemTypeCatId() );
        this.setItemTransactionId( item.getItemTransactionId() );
        this.setName( item.getName() );
        this.setPrice( item.getPrice() );
        this.setOriginalPrice( item.getOriginalPrice() );
        this.setDiscount( item.getDiscount() );
        this.setDescription( item.getDescription() );
        this.setFleetCost( item.getFleetCost() );
        this.setSizeId( item.getSizeId() );
        this.setLastLevelCategoryId( item.getLastLevelCategoryId() );
    }

    public String getId() {
        return id;
    }

    public ItemDto setId(String id) {
        this.id = id;
        return this;
    }

    public int getStatusId() {
        return statusId;
    }

    public ItemDto setStatusId(int statusId) {
        this.statusId = statusId;
        return this;
    }

    public int getItemColorId() {
        return itemColorId;
    }

    public ItemDto setItemColorId(int itemColorId) {
        this.itemColorId = itemColorId;
        return this;
    }

    public int getItemTypeCatId() {
        return itemTypeCatId;
    }

    public ItemDto setItemTypeCatId(int itemTypeCatId) {
        this.itemTypeCatId = itemTypeCatId;
        return this;
    }

    public int getItemTransactionId() {
        return itemTransactionId;
    }

    public ItemDto setItemTransactionId(int itemTransactionId) {
        this.itemTransactionId = itemTransactionId;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public long getPrice() {
        return price;
    }

    public ItemDto setPrice(long price) {
        this.price = price;
        return this;
    }

    public long getOriginalPrice() {
        return originalPrice;
    }

    public ItemDto setOriginalPrice(long originalPrice) {
        this.originalPrice = originalPrice;
        return this;
    }

    public double getDiscount() {
        return discount;
    }

    public ItemDto setDiscount(double discount) {
        this.discount = discount;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getFleetCost() {
        return fleetCost;
    }

    public ItemDto setFleetCost(double fleetCost) {
        this.fleetCost = fleetCost;
        return this;
    }

    public String getSizeId() {
        return sizeId;
    }

    public ItemDto setSizeId(String sizeId) {
        this.sizeId = sizeId;
        return this;
    }

    public int getLastLevelCategoryId() {
        return lastLevelCategoryId;
    }

    public ItemDto setLastLevelCategoryId(int lastLevelCategoryId) {
        this.lastLevelCategoryId = lastLevelCategoryId;
        return this;
    }

    public UserDto getUser() {
        return user;
    }

    public ItemDto setUser(UserDto user) {
        this.user = user;
        return this;
    }
}
