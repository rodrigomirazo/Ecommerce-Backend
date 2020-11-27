package com.ecommerce.bicicle.dto;

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
    private List<ItemImgUrlsDto> itemImgUrls;
    private List<FloatingCharsRelDto> itemFloatingChars;
    private String backRear;
    private String model;
    private String suspension;
    private String ruedos;
    private String cassette;
    private String series;
    private String gearLevel;
    private String multiplication;
    private boolean isModified;
    private String comments;
    private int frameRate;
    private int ruedosRate;
    private int wheelsRate;
    private int componentsRate;

    public ItemSavedDto() { }

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

    public List<FloatingCharsRelDto> getItemFloatingChars() {
        return itemFloatingChars;
    }

    public ItemSavedDto setItemFloatingChars(List<FloatingCharsRelDto> itemFloatingChars) {
        this.itemFloatingChars = itemFloatingChars;
        return this;
    }

    public List<ItemImgUrlsDto> getItemImgUrls() {
        return itemImgUrls;
    }

    public ItemSavedDto setItemImgUrls(List<ItemImgUrlsDto> itemImgUrls) {
        this.itemImgUrls = itemImgUrls;
        return this;
    }

    public String getBackRear() {
        return backRear;
    }

    public ItemSavedDto setBackRear(String backRear) {
        this.backRear = backRear;
        return this;
    }

    public String getModel() {
        return model;
    }

    public ItemSavedDto setModel(String model) {
        this.model = model;
        return this;
    }

    public String getSuspension() {
        return suspension;
    }

    public ItemSavedDto setSuspension(String suspension) {
        this.suspension = suspension;
        return this;
    }

    public String getRuedos() {
        return ruedos;
    }

    public ItemSavedDto setRuedos(String ruedos) {
        this.ruedos = ruedos;
        return this;
    }

    public String getCassette() {
        return cassette;
    }

    public ItemSavedDto setCassette(String cassette) {
        this.cassette = cassette;
        return this;
    }

    public String getSeries() {
        return series;
    }

    public ItemSavedDto setSeries(String series) {
        this.series = series;
        return this;
    }

    public String getGearLevel() {
        return gearLevel;
    }

    public ItemSavedDto setGearLevel(String gearLevel) {
        this.gearLevel = gearLevel;
        return this;
    }

    public String getMultiplication() {
        return multiplication;
    }

    public ItemSavedDto setMultiplication(String multiplication) {
        this.multiplication = multiplication;
        return this;
    }

    public boolean getIsModified() {
        return isModified;
    }

    public ItemSavedDto setIsModified(boolean modified) {
        isModified = modified;
        return this;
    }

    public String getComments() {
        return comments;
    }

    public ItemSavedDto setComments(String comments) {
        this.comments = comments;
        return this;
    }

    public int getFrameRate() {
        return frameRate;
    }

    public ItemSavedDto setFrameRate(int frameRate) {
        this.frameRate = frameRate;
        return this;
    }

    public int getRuedosRate() {
        return ruedosRate;
    }

    public ItemSavedDto setRuedosRate(int ruedosRate) {
        this.ruedosRate = ruedosRate;
        return this;
    }

    public int getWheelsRate() {
        return wheelsRate;
    }

    public ItemSavedDto setWheelsRate(int wheelsRate) {
        this.wheelsRate = wheelsRate;
        return this;
    }

    public int getComponentsRate() {
        return componentsRate;
    }

    public ItemSavedDto setComponentsRate(int componentsRate) {
        this.componentsRate = componentsRate;
        return this;
    }

    @Override
    public String toString() {
        return "ItemSavedDto{" +
                "id=" + id +
                ", statusId=" + statusId +
                ", itemColorId=" + itemColorId +
                ", itemTypeCatId=" + itemTypeCatId +
                ", itemTransactionId=" + itemTransactionId +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", originalPrice=" + originalPrice +
                ", discount=" + discount +
                ", description='" + description + '\'' +
                ", fleetCost=" + fleetCost +
                ", sizeId='" + sizeId + '\'' +
                ", lastLevelCategoryId=" + lastLevelCategoryId +
                ", user=" + user +
                ", itemImgUrls=" + itemImgUrls +
                ", itemFloatingChars=" + itemFloatingChars +
                ", backRear='" + backRear + '\'' +
                ", model='" + model + '\'' +
                ", suspension='" + suspension + '\'' +
                ", ruedos='" + ruedos + '\'' +
                ", casette='" + cassette + '\'' +
                ", series='" + series + '\'' +
                ", gearLevel='" + gearLevel + '\'' +
                ", multiplication='" + multiplication + '\'' +
                ", isModified=" + isModified +
                ", comments='" + comments + '\'' +
                ", frameRate=" + frameRate +
                ", ruedosRate=" + ruedosRate +
                ", wheelsRate=" + wheelsRate +
                ", componentsRate=" + componentsRate +
                '}';
    }
}
