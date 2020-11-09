package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.dto.ItemFilterDto;
import com.ecommerce.bicicle.dto.ItemSavedDto;

import java.util.List;

public interface ItemService {

    List<ItemSavedDto> get();

    List<ItemSavedDto> getItemsByType(int itemTypeCatId);

    List<ItemSavedDto> getFilteredItems(ItemFilterDto itemFilterDto);

    List<ItemSavedDto> getItemsByUser(int userId);

    ItemSavedDto save(ItemSavedDto ItemDTo);

    void delete(Integer userVendorId);
}
