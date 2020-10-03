package com.ecommerce.bicicle.entity;

import com.ecommerce.bicicle.dto.ItemTypeCatDto;

import javax.persistence.*;

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

}
