package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.dto.ItemDTo;

import java.util.List;

public interface ItemService {

    List<ItemDTo> get();

    List<ItemDTo> getItemsByType(int itemTypeCatId);

    ItemDTo save(ItemDTo ItemDTo);

    void delete(Long userVendorId);
}
