package com.ecommerce.bicicle.dto;

import java.io.Serializable;

public class ItemColorCatDto implements Serializable {

    private static final long serialVersionUID = -8184459608728392711L;
    private int id;
    private String name;

    public ItemColorCatDto() {
    }

    public int getId() {
        return id;
    }

    public ItemColorCatDto setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemColorCatDto setName(String name) {
        this.name = name;
        return this;
    }
}
