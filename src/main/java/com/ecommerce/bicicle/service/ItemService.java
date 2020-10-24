package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.dto.ItemDto;
import com.ecommerce.bicicle.dto.ItemSavedDto;
import com.ecommerce.bicicle.dto.UserItemsDto;

import java.util.List;

public interface ItemService {

    List<ItemSavedDto> get();

    List<ItemSavedDto> getItemsByType(int itemTypeCatId);

    List<ItemSavedDto> getItemsByUser(int userId);

    ItemSavedDto save(ItemSavedDto ItemDTo);

    void delete(Integer userVendorId);
}
