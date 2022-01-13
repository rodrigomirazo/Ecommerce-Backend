package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.dto.ItemFilterDto;
import com.ecommerce.bicicle.dto.ItemSavedDto;

import java.sql.Timestamp;
import java.util.List;

public interface ItemService {

    List<ItemSavedDto> get();

    ItemSavedDto getItemsById(int itemId);

    List<ItemSavedDto> getItemsByType(int itemTypeCatId);

    List<ItemSavedDto> getFilteredItems(ItemFilterDto itemFilterDto);

    List<ItemSavedDto> getItemsToApprovedOrRejected(
            Boolean diagnostApproved, Timestamp createdTimeStart, Timestamp createdTimeEnd, Integer pageNum, Integer pageSize);

    List<ItemSavedDto> getItemsNotYetApproved(
            Timestamp createdTimeStart, Timestamp createdTimeEnd, Integer pageNum, Integer pageSize);


    ItemSavedDto itemSavedDiagnost(Integer itemId, Boolean passed, String comments);

    List<ItemSavedDto> getItemsByUser(int userId);

    ItemSavedDto save(ItemSavedDto ItemDTo, Integer userId);

    void delete(Integer userVendorId);
}
