package com.ecommerce.bicicle.dto;

import java.io.Serializable;

public class ItemStatusCatDto implements Serializable {

    private static final long serialVersionUID = -4544755505336026511L;
    private int id;
    private String name;

    public ItemStatusCatDto() {
    }

    public int getId() {
        return id;
    }

    public ItemStatusCatDto setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemStatusCatDto setName(String name) {
        this.name = name;
        return this;
    }
}
