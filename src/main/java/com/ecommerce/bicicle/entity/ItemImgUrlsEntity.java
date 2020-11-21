package com.ecommerce.bicicle.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "item_img_urls")
public class ItemImgUrlsEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "item_id")
    private int itemId;

    @Column(name = "created_time")
    private Timestamp createdTime;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "img_server")
    private String imgServer;

    public ItemImgUrlsEntity() {
    }

    public int getId() {
        return id;
    }

    public ItemImgUrlsEntity setId(int id) {
        this.id = id;
        return this;
    }

    public int getItemId() {
        return itemId;
    }

    public ItemImgUrlsEntity setItemId(int itemId) {
        this.itemId = itemId;
        return this;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public ItemImgUrlsEntity setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public ItemImgUrlsEntity setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getImgServer() {
        return imgServer;
    }

    public ItemImgUrlsEntity setImgServer(String imgServer) {
        this.imgServer = imgServer;
        return this;
    }
}
