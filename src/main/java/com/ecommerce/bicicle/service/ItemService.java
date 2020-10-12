package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.dto.ItemDto;
import com.ecommerce.bicicle.dto.UserItemsDto;

import java.util.List;

public interface ItemService {

    List<ItemDto> get();

    List<ItemDto> getItemsByType(int itemTypeCatId);

    List<ItemDto> getItemsByUser(int userId);

    ItemDto save(ItemDto ItemDTo);

    void delete(Long userVendorId);
}
