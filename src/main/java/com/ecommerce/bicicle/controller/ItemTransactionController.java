package com.ecommerce.bicicle.controller;

import com.ecommerce.bicicle.constants.EndpointNames;
import com.ecommerce.bicicle.dto.ItemSavedDto;
import com.ecommerce.bicicle.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = EndpointNames.URI)
public class ItemTransactionController {

    private static final String itemTransactionUri = EndpointNames.ITEM_TRANSACTION_CONTROLLER;
    
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = itemTransactionUri, method = {RequestMethod.GET})
    public @ResponseBody
    List<ItemSavedDto> getItem() {

        List<ItemSavedDto> itemEntities = itemService.get();

        return itemEntities;
    }

    @RequestMapping(value = itemTransactionUri, method = {RequestMethod.PUT})
    public @ResponseBody
    ItemSavedDto getItem(ItemSavedDto item) {

        ItemSavedDto saveItemUser = itemService.save(item);

        return saveItemUser;
    }

    @RequestMapping(value = itemTransactionUri, method = {RequestMethod.DELETE})
    public @ResponseBody
    void getItem(Integer itemId) {

        itemService.delete(itemId);
    }
}
