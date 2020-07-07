package com.Eclothes.item.service.impl;

import com.Eclothes.item.dto.ItemCategoryDto;
import com.Eclothes.item.entity.ItemCategory;
import com.Eclothes.item.repository.ItemCategoryRepository;
import com.Eclothes.item.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

    @Autowired
    ItemCategoryRepository itemCategoryRepository;

    @Override
    public List<ItemCategoryDto> get(Long itemTypeId) {

        List<ItemCategory> itemCategories = StreamSupport.stream(
                itemCategoryRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        List<ItemCategoryDto> itemCategoryDtos =
                itemCategories.stream().map(ItemCategoryDto::new).collect(Collectors.toList());

        return itemCategoryDtos;
    }

    @Override
    public ItemCategoryDto save(ItemCategoryDto itemCategoryDto) {

        ItemCategory itemCategory = new ItemCategory(itemCategoryDto);
        ItemCategory itemCategorySaved = itemCategoryRepository.save(itemCategory);

        return new ItemCategoryDto(itemCategorySaved);
    }

    @Override
    public void delete(Long userVendorId) {
        itemCategoryRepository.deleteById(userVendorId);
    }
}
