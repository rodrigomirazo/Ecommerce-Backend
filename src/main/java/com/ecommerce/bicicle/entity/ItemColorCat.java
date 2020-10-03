package com.ecommerce.bicicle.entity;

import javax.persistence.*;

@Entity
@Table(name = "item_color_cat")
public class ItemColorCat {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    public ItemColorCat() {
    }

    public int getId() {
        return id;
    }

    public ItemColorCat setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemColorCat setName(String name) {
        this.name = name;
        return this;
    }
}
