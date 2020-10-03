package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.entity.ItemColorCat;

import java.util.List;

public interface ItemColorCatService {
    List<ItemColorCat> get();

    ItemColorCat save(ItemColorCat itemColorCat);

    void delete(Long itemColorId);
}
