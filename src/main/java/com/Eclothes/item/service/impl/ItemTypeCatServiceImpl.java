package com.Eclothes.item.service.impl;

import com.Eclothes.item.dto.ItemTypeCatDto;
import com.Eclothes.item.entity.ItemTypeCat;
import com.Eclothes.item.repository.ItemCategoryRepository;
import com.Eclothes.item.repository.ItemTypeCatRepository;
import com.Eclothes.item.service.ItemTypeCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ItemTypeCatServiceImpl implements ItemTypeCatService {

    @Autowired
    ItemTypeCatRepository itemTypeCatRepository;

    @Autowired
    ItemCategoryRepository itemCategoryRepository;

    @Override
    public List<ItemTypeCatDto> get(String categoryId) {

        List<ItemTypeCat> itemTypeCats = StreamSupport.stream(
                itemTypeCatRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        List<ItemTypeCatDto> itemTypeCatDtos =
        itemTypeCats.stream().map(ItemTypeCatDto::new).collect(Collectors.toList());

        return itemTypeCatDtos;
    }

    @Override
    public ItemTypeCatDto save(ItemTypeCatDto itemTypeCatDto) {

        ItemTypeCat itemTypeCat = new ItemTypeCat(itemTypeCatDto);
        ItemTypeCat itemTypeCatSaved = itemTypeCatRepository.save(itemTypeCat);

        return new ItemTypeCatDto(itemTypeCatSaved);
    }

    @Override
    public void delete(Long itemTypeCatId) {
        itemTypeCatRepository.deleteById(itemTypeCatId);
    }
}
