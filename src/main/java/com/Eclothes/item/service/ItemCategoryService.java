package com.Eclothes.item.service;

import com.Eclothes.item.dto.ItemCategoryDto;
import com.Eclothes.item.entity.ItemCategory;
import java.util.List;

public interface ItemCategoryService {

    List<ItemCategoryDto> get(Long itemTypeId);

    ItemCategoryDto save(ItemCategoryDto itemCategory);

    void delete(Long userVendorId);
}
