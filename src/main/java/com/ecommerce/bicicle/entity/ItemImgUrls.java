package com.ecommerce.bicicle.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "item_img_urls")
public class ItemImgUrls {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "item_id")
    private int itemId;

    @Column(name = "created_time")
    private Timestamp createdTime;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "img_server")
    private String imgServer;

    public ItemImgUrls() {
    }

    public int getId() {
        return id;
    }

    public ItemImgUrls setId(int id) {
        this.id = id;
        return this;
    }

    public int getItemId() {
        return itemId;
    }

    public ItemImgUrls setItemId(int itemId) {
        this.itemId = itemId;
        return this;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public ItemImgUrls setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public ItemImgUrls setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getImgServer() {
        return imgServer;
    }

    public ItemImgUrls setImgServer(String imgServer) {
        this.imgServer = imgServer;
        return this;
    }
}
