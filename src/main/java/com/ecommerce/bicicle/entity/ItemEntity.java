package com.ecommerce.bicicle.entity;

import com.ecommerce.bicicle.dto.ItemDto;
import com.ecommerce.bicicle.dto.UserDto;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public ItemEntity() { }

    public Integer getId() {
        return id;
    }

    public ItemEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public int getStatusId() {
        return statusId;
    }

    public ItemEntity setStatusId(int statusId) {
        this.statusId = statusId;
        return this;
    }

    public int getItemColorId() {
        return itemColorId;
    }

    public ItemEntity setItemColorId(int itemColorId) {
        this.itemColorId = itemColorId;
        return this;
    }

    public int getItemTypeCatId() {
        return itemTypeCatId;
    }

    public ItemEntity setItemTypeCatId(int itemTypeCatId) {
        this.itemTypeCatId = itemTypeCatId;
        return this;
    }

    public int getItemTransactionId() {
        return itemTransactionId;
    }

    public ItemEntity setItemTransactionId(int itemTransactionId) {
        this.itemTransactionId = itemTransactionId;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemEntity setName(String name) {
        this.name = name;
        return this;
    }

    public long getPrice() {
        return price;
    }

    public ItemEntity setPrice(long price) {
        this.price = price;
        return this;
    }

    public long getOriginalPrice() {
        return originalPrice;
    }

    public ItemEntity setOriginalPrice(long originalPrice) {
        this.originalPrice = originalPrice;
        return this;
    }

    public double getDiscount() {
        return discount;
    }

    public ItemEntity setDiscount(double discount) {
        this.discount = discount;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getFleetCost() {
        return fleetCost;
    }

    public ItemEntity setFleetCost(double fleetCost) {
        this.fleetCost = fleetCost;
        return this;
    }

    public String getSizeId() {
        return sizeId;
    }

    public ItemEntity setSizeId(String sizeId) {
        this.sizeId = sizeId;
        return this;
    }

    public int getLastLevelCategoryId() {
        return lastLevelCategoryId;
    }

    public ItemEntity setLastLevelCategoryId(int lastLevelCategoryId) {
        this.lastLevelCategoryId = lastLevelCategoryId;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public ItemEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}
