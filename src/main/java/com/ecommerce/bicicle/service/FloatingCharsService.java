package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.dto.ItemFloatingCharsCatDto;
import com.ecommerce.bicicle.dto.ItemFloatingCharsDto;

import java.util.List;

public interface FloatingCharsService {

    ItemFloatingCharsDto saveFloatingCharsDtos(ItemFloatingCharsDto itemFloatingCharRequest);

    List<ItemFloatingCharsDto> getItemFloatingCharsDtos();

    void deleteFloatingChar(Integer itemFloatingCharId);

    ItemFloatingCharsCatDto saveItemFloatingCharsCat(Integer floatingCharsCat, ItemFloatingCharsCatDto itemFloatingCharsCatRequest) throws Exception;

    List<ItemFloatingCharsCatDto> getItemFloatingCharsCat(Integer itemFloatingCharsCatId);

    void deleteFloatingCharCat(Integer itemFloatingCharCatId);
}
