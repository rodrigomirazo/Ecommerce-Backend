package com.Eclothes.item.entity;

public class ItemCharEntity<T> {

    private int itemId;
    private String brand;
    private String color;
    private String status;
    private T size;
    private double price;

    public ItemCharEntity() {
    }

    public int getItemId() {
        return itemId;
    }

    public ItemCharEntity<T> setItemId(int itemId) {
        this.itemId = itemId;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public ItemCharEntity<T> setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getColor() {
        return color;
    }

    public ItemCharEntity<T> setColor(String color) {
        this.color = color;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ItemCharEntity<T> setStatus(String status) {
        this.status = status;
        return this;
    }

    public T getSize() {
        return size;
    }

    public ItemCharEntity<T> setSize(T size) {
        this.size = size;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public ItemCharEntity<T> setPrice(double price) {
        this.price = price;
        return this;
    }
}
