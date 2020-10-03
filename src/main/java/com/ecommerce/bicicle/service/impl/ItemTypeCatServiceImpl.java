package com.ecommerce.bicicle.service.impl;

import com.ecommerce.bicicle.dto.ItemTypeCatDto;
import com.ecommerce.bicicle.entity.ItemTypeCat;
import com.ecommerce.bicicle.repository.ItemCategoryRepository;
import com.ecommerce.bicicle.repository.ItemTypeCatRepository;
import com.ecommerce.bicicle.service.ItemTypeCatService;
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
