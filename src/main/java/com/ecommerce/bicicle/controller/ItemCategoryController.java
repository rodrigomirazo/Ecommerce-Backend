package com.ecommerce.bicicle.controller;

import com.ecommerce.bicicle.constants.EndpointNames;
import com.ecommerce.bicicle.dto.ItemCategoryDto;
import com.ecommerce.bicicle.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = EndpointNames.URI)
public class ItemCategoryController {

    private static final String itemCatUri = EndpointNames.ITEM_CATEGORY_CONTROLLER;

    @Autowired
    private ItemCategoryService itemCatService;

    @RequestMapping(value = itemCatUri, method = {RequestMethod.GET})
    public @ResponseBody
    List<ItemCategoryDto> get(Long itemTypeId) {
        List<ItemCategoryDto> itemCategoryDtos = itemCatService.get(itemTypeId);
        return itemCategoryDtos;
    }

    @RequestMapping(value = itemCatUri, method = {RequestMethod.PUT})
    public @ResponseBody
    ItemCategoryDto save(ItemCategoryDto itemCategory) {
        ItemCategoryDto itemCategoryDto = itemCatService.save(itemCategory);
        return itemCategoryDto;
    }

    @RequestMapping(value = itemCatUri, method = {RequestMethod.DELETE})
    public @ResponseBody
    void delete(Long itemCatId) {
        itemCatService.delete(itemCatId);
    }
}
