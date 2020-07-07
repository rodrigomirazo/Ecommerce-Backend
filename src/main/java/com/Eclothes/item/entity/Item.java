package com.Eclothes.item.entity;

import com.Eclothes.item.dto.ItemDTo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;

    @Column(name = "status_id")
    private int statusId;

    @Column(name = "color_id")
    private int itemColorId;

    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Column(name = "type_id")
    private int itemTypeCatId;

    @Column(name = "transaction_id")
    private int itemTransactionId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private long price;

    @Column(name = "original_price")
    private long originalPrice;

    @Column(name = "discount")
    private double discount;

    @Column(name = "description")
    private String description;

    @Column(name = "fleetCost")
    private double fleetCost;

    @Column(name = "size_id")
    private String sizeId;

    @Column(name = "last_level_category_id")
    private int lastLevelCategoryId;

    public Item() { }

    public Item(ItemDTo item) {
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

    public Item setId(String id) {
        this.id = id;
        return this;
    }

    public int getStatusId() {
        return statusId;
    }

    public Item setStatusId(int statusId) {
        this.statusId = statusId;
        return this;
    }

    public int getItemColorId() {
        return itemColorId;
    }

    public Item setItemColorId(int itemColorId) {
        this.itemColorId = itemColorId;
        return this;
    }

    public int getItemTypeCatId() {
        return itemTypeCatId;
    }

    public Item setItemTypeCatId(int itemTypeCatId) {
        this.itemTypeCatId = itemTypeCatId;
        return this;
    }

    public int getItemTransactionId() {
        return itemTransactionId;
    }

    public Item setItemTransactionId(int itemTransactionId) {
        this.itemTransactionId = itemTransactionId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public long getPrice() {
        return price;
    }

    public Item setPrice(long price) {
        this.price = price;
        return this;
    }

    public long getOriginalPrice() {
        return originalPrice;
    }

    public Item setOriginalPrice(long originalPrice) {
        this.originalPrice = originalPrice;
        return this;
    }

    public double getDiscount() {
        return discount;
    }

    public Item setDiscount(double discount) {
        this.discount = discount;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Item setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getFleetCost() {
        return fleetCost;
    }

    public Item setFleetCost(double fleetCost) {
        this.fleetCost = fleetCost;
        return this;
    }

    public String getSizeId() {
        return sizeId;
    }

    public Item setSizeId(String sizeId) {
        this.sizeId = sizeId;
        return this;
    }

    public int getLastLevelCategoryId() {
        return lastLevelCategoryId;
    }

    public Item setLastLevelCategoryId(int lastLevelCategoryId) {
        this.lastLevelCategoryId = lastLevelCategoryId;
        return this;
    }
}
