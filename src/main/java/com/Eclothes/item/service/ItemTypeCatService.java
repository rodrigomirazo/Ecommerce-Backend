package com.Eclothes.item.service;

import com.Eclothes.item.dto.ItemTypeCatDto;
import com.Eclothes.item.entity.ItemTypeCat;

import java.util.List;

public interface ItemTypeCatService {
    List<ItemTypeCatDto> get();

    ItemTypeCatDto save(ItemTypeCatDto itemTypeCat);

    void delete(Long itemTypeCatId);
}
