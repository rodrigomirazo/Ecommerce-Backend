package com.ecommerce.bicicle.entity;

import javax.persistence.*;

@Entity
@Table(name = "item_status_cat")
public class ItemStatusCat {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    public ItemStatusCat() {
    }

    public int getId() {
        return id;
    }

    public ItemStatusCat setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemStatusCat setName(String name) {
        this.name = name;
        return this;
    }
}
