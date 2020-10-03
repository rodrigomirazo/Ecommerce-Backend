package com.ecommerce.bicicle.entity;

import javax.persistence.*;

@Entity
@Table(name = "item_floating_chars_rel")
public class ItemFloatingCharsRelEntity {

    @Id
    @Column(name = "item_floating_chars_rel_id")
    private int itemFloatingCharsRelId;

    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "floating_char_cat_id")
    private Integer floatingCharCatId;

    public ItemFloatingCharsRelEntity() {
    }

    public int getItemFloatingCharsRelId() {
        return itemFloatingCharsRelId;
    }

    public ItemFloatingCharsRelEntity setItemFloatingCharsRelId(int itemFloatingCharsRelId) {
        this.itemFloatingCharsRelId = itemFloatingCharsRelId;
        return this;
    }

    public Integer getItemId() {
        return itemId;
    }

    public ItemFloatingCharsRelEntity setItemId(Integer itemId) {
        this.itemId = itemId;
        return this;
    }

    public Integer getFloatingCharCatId() {
        return floatingCharCatId;
    }

    public ItemFloatingCharsRelEntity setFloatingCharCatId(Integer floatingCharCatId) {
        this.floatingCharCatId = floatingCharCatId;
        return this;
    }
}
