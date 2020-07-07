package com.Eclothes.item.entity;

import com.Eclothes.item.dto.ItemTypeCatDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item_type_cat")
@Access(value= AccessType.FIELD)
public class ItemTypeCat {

    @Id
    @Access(value=AccessType.FIELD)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "itemTypeCat", cascade = {
            CascadeType.ALL
    })
    List<ItemCategory> itemCategories;

    public ItemTypeCat() {
    }

    public ItemTypeCat(ItemTypeCatDto itemTypeCatDto) {
        this.setId(itemTypeCatDto.getId());
        this.setName(itemTypeCatDto.getCategoryName());
    }

    public Integer getId() {
        return id;
    }

    public ItemTypeCat setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemTypeCat setName(String name) {
        this.name = name;
        return this;
    }

    public List<ItemCategory> getItemCategories() {
        return itemCategories;
    }

    public ItemTypeCat setItemCategories(List<ItemCategory> itemCategories) {
        this.itemCategories = itemCategories;
        return this;
    }
}
