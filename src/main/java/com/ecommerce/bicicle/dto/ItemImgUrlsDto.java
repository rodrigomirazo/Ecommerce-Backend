package com.ecommerce.bicicle.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class ItemImgUrlsDto implements Serializable {

    private static final long serialVersionUID = -2466209079245728009L;
    private int id;
    private int itemId;
    private Timestamp createdTime;
    private String imgUrl;
    private String imgServer;

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

    public String getImgServer() {
        return imgServer;
    }

    public ItemImgUrlsDto setImgServer(String imgServer) {
        this.imgServer = imgServer;
        return this;
    }
}
