package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.dto.ItemTypeCatDto;

import java.util.List;

public interface ItemTypeCatService {
    List<ItemTypeCatDto> get(String categoryId);

    ItemTypeCatDto save(ItemTypeCatDto itemTypeCat);

    void delete(Long itemTypeCatId);
}
