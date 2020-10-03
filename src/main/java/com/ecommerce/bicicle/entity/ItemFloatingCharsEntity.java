package com.ecommerce.bicicle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_floating_chars")
public class ItemFloatingCharsEntity {

    @Id
    @Column(name = "floating_char_id")
    private int floatingCharId;

    @Column(name = "char_name")
    private String charName;

    public ItemFloatingCharsEntity() {
    }

    public int getFloatingCharId() {
        return floatingCharId;
    }

    public ItemFloatingCharsEntity setFloatingCharId(int floatingCharId) {
        this.floatingCharId = floatingCharId;
        return this;
    }

    public String getCharName() {
        return charName;
    }

    public ItemFloatingCharsEntity setCharName(String charName) {
        this.charName = charName;
        return this;
    }
}
