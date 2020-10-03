package com.ecommerce.bicicle.service.impl;

import com.ecommerce.bicicle.dto.ItemCategoryDto;
import com.ecommerce.bicicle.entity.ItemCategory;
import com.ecommerce.bicicle.repository.ItemCategoryRepository;
import com.ecommerce.bicicle.service.ItemCategoryService;
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

        List<ItemCategory> allCategoriesRepo = StreamSupport.stream(
                itemCategoryRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        List<ItemCategory> itemTypesRepo = StreamSupport.stream(
                itemCategoryRepository.findByItemTypeId(-1).spliterator(), false)
                .collect(Collectors.toList());


        List<ItemCategoryDto> allCategories =
                allCategoriesRepo.stream().map(ItemCategoryDto::new).collect(Collectors.toList());

        List<ItemCategoryDto> itemTypes =
                itemTypesRepo.stream().map(ItemCategoryDto::new).collect(Collectors.toList());

        itemTypes = this.recursion(itemTypes, allCategories);

        return itemTypes;
    }

    List<ItemCategoryDto> recursion(List<ItemCategoryDto> itemTypes, List<ItemCategoryDto> allCategories) {
        for (int i = 0; i < itemTypes.size(); i++) {

            int count = i;
            List<ItemCategoryDto> subCategories = allCategories.stream().filter(itemCategoryDto -> itemCategoryDto.getParentId() != null && itemCategoryDto.getParentId() == itemTypes.get(count).getId()).collect(Collectors.toList());
            itemTypes.get(count).setSubCategories(subCategories);

            if(itemTypes.size() > 0) {
                this.recursion(itemTypes.get(count).getSubCategories(), allCategories);
            }
        }
        return itemTypes;
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
