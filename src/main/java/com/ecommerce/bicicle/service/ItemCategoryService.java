package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.dto.ItemCategoryDto;

import java.util.List;

public interface ItemCategoryService {

    List<ItemCategoryDto> get(Long itemTypeId);

    ItemCategoryDto save(ItemCategoryDto itemCategory);

    void delete(Long userVendorId);
}
