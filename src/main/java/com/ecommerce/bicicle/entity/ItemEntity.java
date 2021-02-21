package com.ecommerce.bicicle.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

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

    @Column(name = "year")
    private Integer year;

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

    @Column(name = "back_rear")
    private String backRear;

    @Column(name = "front_rear")
    private String frontRear;

    @Column(name = "model")
    private String model;

    @Column(name = "suspension")
    private String suspension;

    @Column(name = "back_suspension")
    private String backSuspension;

    @Column(name = "ruedos")
    private String ruedos;

    @Column(name = "casette")
    private String cassette;

    @Column(name = "series")
    private String series;

    @Column(name = "gear_level")
    private String gearLevel;

    @Column(name = "multiplication")
    private String multiplication;

    @Column(name = "is_modified")
    private boolean isModified;

    @Column(name = "comments")
    private String comments;

    @Column(name = "frame_rate")
    private int frameRate;

    @Column(name = "ruedos_rate")
    private int ruedosRate;

    @Column(name = "wheels_rate")
    private int wheelsRate;

    @Column(name = "components_rate")
    private int componentsRate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemId")
    private List<ItemFloatingCharsRelEntity> itemFloatingCharsRel;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemId")
    private List<ItemImgUrlsEntity> itemImgUrls;

    @Column(name = "created_time")
    private Timestamp createdTime;

    @Column(name = "payment_confirmed")
    private boolean paymentConfirmed;

    @Column(name = "diagnost_approved")
    private Boolean diagnostApproved;

    @Column(name = "diagnost_time")
    private Timestamp diagnostTime;

    @Column(name = "diagnost_comments")
    private String diagnostComments;

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

    public Integer getYear() {
        return year;
    }

    public ItemEntity setYear(Integer year) {
        this.year = year;
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

    public List<ItemFloatingCharsRelEntity> getItemFloatingCharsRel() {
        return itemFloatingCharsRel;
    }

    public ItemEntity setItemFloatingCharsRel(List<ItemFloatingCharsRelEntity> itemFloatingCharsRel) {
        this.itemFloatingCharsRel = itemFloatingCharsRel;
        return this;
    }

    public List<ItemImgUrlsEntity> getItemImgUrls() {
        return itemImgUrls;
    }

    public ItemEntity setItemImgUrls(List<ItemImgUrlsEntity> itemImgUrls) {
        this.itemImgUrls = itemImgUrls;
        return this;
    }

    public String getBackRear() {
        return backRear;
    }

    public ItemEntity setBackRear(String backRear) {
        this.backRear = backRear;
        return this;
    }

    public String getFrontRear() {
        return frontRear;
    }

    public ItemEntity setFrontRear(String frontRear) {
        this.frontRear = frontRear;
        return this;
    }

    public String getModel() {
        return model;
    }

    public ItemEntity setModel(String model) {
        this.model = model;
        return this;
    }

    public String getSuspension() {
        return suspension;
    }

    public ItemEntity setSuspension(String suspension) {
        this.suspension = suspension;
        return this;
    }

    public String getBackSuspension() {
        return backSuspension;
    }

    public ItemEntity setBackSuspension(String backSuspension) {
        this.backSuspension = backSuspension;
        return this;
    }

    public String getRuedos() {
        return ruedos;
    }

    public ItemEntity setRuedos(String ruedos) {
        this.ruedos = ruedos;
        return this;
    }

    public String getCassette() {
        return cassette;
    }

    public ItemEntity setCassette(String cassette) {
        this.cassette = cassette;
        return this;
    }

    public String getSeries() {
        return series;
    }

    public ItemEntity setSeries(String series) {
        this.series = series;
        return this;
    }

    public String getGearLevel() {
        return gearLevel;
    }

    public ItemEntity setGearLevel(String gearLevel) {
        this.gearLevel = gearLevel;
        return this;
    }

    public String getMultiplication() {
        return multiplication;
    }

    public ItemEntity setMultiplication(String multiplication) {
        this.multiplication = multiplication;
        return this;
    }

    public boolean getIsModified() {
        return isModified;
    }

    public ItemEntity setIsModified(boolean modified) {
        isModified = modified;
        return this;
    }

    public String getComments() {
        return comments;
    }

    public ItemEntity setComments(String comments) {
        this.comments = comments;
        return this;
    }

    public int getFrameRate() {
        return frameRate;
    }

    public ItemEntity setFrameRate(int frameRate) {
        this.frameRate = frameRate;
        return this;
    }

    public int getRuedosRate() {
        return ruedosRate;
    }

    public ItemEntity setRuedosRate(int ruedosRate) {
        this.ruedosRate = ruedosRate;
        return this;
    }

    public int getWheelsRate() {
        return wheelsRate;
    }

    public ItemEntity setWheelsRate(int wheelsRate) {
        this.wheelsRate = wheelsRate;
        return this;
    }

    public int getComponentsRate() {
        return componentsRate;
    }

    public ItemEntity setComponentsRate(int componentsRate) {
        this.componentsRate = componentsRate;
        return this;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public ItemEntity setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public boolean getPaymentConfirmed() {
        return paymentConfirmed;
    }

    public ItemEntity setPaymentConfirmed(boolean paymentConfirmed) {
        this.paymentConfirmed = paymentConfirmed;
        return this;
    }

    public Boolean getDiagnostApproved() {
        return diagnostApproved;
    }

    public ItemEntity setDiagnostApproved(Boolean diagnostApproved) {
        this.diagnostApproved = diagnostApproved;
        return this;
    }

    public Timestamp getDiagnostTime() {
        return diagnostTime;
    }

    public ItemEntity setDiagnostTime(Timestamp diagnostTime) {
        this.diagnostTime = diagnostTime;
        return this;
    }

    public String getDiagnostComments() {
        return diagnostComments;
    }

    public ItemEntity setDiagnostComments(String diagnostComments) {
        this.diagnostComments = diagnostComments;
        return this;
    }

    @Override
    public String toString() {
        return "ItemEntity{" +
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
                ", user=" + user +
                ", itemFloatingCharsRel=" + itemFloatingCharsRel +
                ", itemImgUrls=" + itemImgUrls +
                '}';
    }
}
