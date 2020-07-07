package com.Eclothes.item.service;

import com.Eclothes.item.entity.ItemCategory;
import com.Eclothes.item.entity.ItemColorCat;

import java.util.List;

public interface ItemColorCatService {
    List<ItemColorCat> get();

    ItemColorCat save(ItemColorCat itemColorCat);

    void delete(Long itemColorId);
}
