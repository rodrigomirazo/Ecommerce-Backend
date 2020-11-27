package com.ecommerce.bicicle.dto;

import javax.imageio.ImageIO;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.sql.Timestamp;

public class ItemImgUrlsDto implements Serializable {

    private static final long serialVersionUID = -2466209079245728009L;
    private int id;
    private int itemId;
    private Timestamp createdTime;
    private String imgUrl;

    public ItemImgUrlsDto() {
    }

    public int getId() {
        return id;
    }

    public ItemImgUrlsDto setId(int id) {
        this.id = id;
        return this;
    }

    public int getItemId() {
        return itemId;
    }

    public ItemImgUrlsDto setItemId(int itemId) {
        this.itemId = itemId;
        return this;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public ItemImgUrlsDto setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public ItemImgUrlsDto setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    @Override
    public String toString() {
        return "ItemImgUrlsDto{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", createdTime=" + createdTime +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
