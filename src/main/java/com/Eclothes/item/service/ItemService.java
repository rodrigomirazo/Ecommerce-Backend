package com.Eclothes.item.service;

import com.Eclothes.item.dto.ItemDTo;
import com.Eclothes.item.entity.Item;
import com.Eclothes.item.entity.ItemTypeCat;

import java.util.List;

public interface ItemService {

    List<ItemDTo> get();

    List<ItemDTo> getItemsByType(int itemTypeCatId);

    ItemDTo save(ItemDTo ItemDTo);

    void delete(Long userVendorId);
}
