package com.ecommerce.bicicle.entity;

import javax.persistence.*;

@Entity
@Table(name = "item_floating_chars_cat")
public class ItemFloatingCharsCatEntity {

    @Id
    @Column(name = "floating_char_cat_id")
    private int floatingCharCatId;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "floating_char_id")
    private ItemFloatingCharsEntity itemFloatingChar;

    @Column(name = "floating_char_name")
    private String floatingCharName;

    public ItemFloatingCharsCatEntity() {
    }

    public int getFloatingCharCatId() {
        return floatingCharCatId;
    }

    public ItemFloatingCharsCatEntity setFloatingCharCatId(int floatingCharCatId) {
        this.floatingCharCatId = floatingCharCatId;
        return this;
    }

    public ItemFloatingCharsEntity getItemFloatingChar() {
        return itemFloatingChar;
    }

    public ItemFloatingCharsCatEntity setItemFloatingChar(ItemFloatingCharsEntity itemFloatingChar) {
        this.itemFloatingChar = itemFloatingChar;
        return this;
    }

    public String getFloatingCharName() {
        return floatingCharName;
    }

    public ItemFloatingCharsCatEntity setFloatingCharName(String floatingCharName) {
        this.floatingCharName = floatingCharName;
        return this;
    }
}
