package com.ecommerce.bicicle.controller;

import com.ecommerce.bicicle.constants.EndpointNames;
import com.ecommerce.bicicle.dto.ItemTypeCatDto;
import com.ecommerce.bicicle.service.ItemTypeCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = EndpointNames.URI)
public class ItemTypeCatController {

    private static final String itemTypeCatUri = EndpointNames.ITEM_TYPE_CAT_CONTROLLER;
    
    @Autowired
    private ItemTypeCatService itemTypeCatService;

    @RequestMapping(value = itemTypeCatUri, method = {RequestMethod.GET})
    public @ResponseBody
    List<ItemTypeCatDto> get(@RequestParam String categoryId) {

        List<ItemTypeCatDto> itemEntities = itemTypeCatService.get(categoryId);

        return itemEntities;
    }

    @RequestMapping(value = itemTypeCatUri, method = {RequestMethod.PUT})
    public @ResponseBody
    ItemTypeCatDto put(ItemTypeCatDto item) {

        ItemTypeCatDto saveItemUser = itemTypeCatService.save(item);

        return saveItemUser;
    }

    @RequestMapping(value = itemTypeCatUri, method = {RequestMethod.DELETE})
    public @ResponseBody
    void delete(Long itemId) {

        itemTypeCatService.delete(itemId);
    }
}
