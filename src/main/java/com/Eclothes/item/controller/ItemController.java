package com.Eclothes.item.controller;

import com.Eclothes.item.config.GlobalConstant;
import com.Eclothes.item.constants.EndpointNames;
import com.Eclothes.item.dto.ItemDTo;
import com.Eclothes.item.entity.Item;
import com.Eclothes.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = EndpointNames.URI)
public class ItemController {

    private static final String itemUri = EndpointNames.ITEM_CONTROLLER;
    
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = itemUri, method = {RequestMethod.GET})
    public @ResponseBody
    List<ItemDTo> getItem() {

        List<ItemDTo> itemEntities = itemService.get();

        return itemEntities;
    }

    @RequestMapping(value = itemUri, method = {RequestMethod.PUT})
    public @ResponseBody
    ItemDTo getItem(ItemDTo item) {

        ItemDTo saveItemUser = itemService.save(item);

        return saveItemUser;
    }

    @RequestMapping(value = itemUri, method = {RequestMethod.DELETE})
    public @ResponseBody
    void getItem(Long itemId) {

        itemService.delete(itemId);
    }
}
