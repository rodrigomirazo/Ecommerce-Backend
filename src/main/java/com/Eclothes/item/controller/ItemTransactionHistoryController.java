package com.Eclothes.item.controller;

import com.Eclothes.item.constants.EndpointNames;
import com.Eclothes.item.dto.ItemTransactionDto;
import com.Eclothes.item.entity.Item;
import com.Eclothes.item.entity.ItemTransaction;
import com.Eclothes.item.service.ItemTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = EndpointNames.URI)
public class ItemTransactionHistoryController {

    private static final String itemTransactionHistoryUri = EndpointNames.ITEM_TRANSACTION_HISTORY_CONTROLLER;
    
    @Autowired
    private ItemTransactionService itemTransaction;

    @RequestMapping(value = itemTransactionHistoryUri, method = {RequestMethod.GET})
    public @ResponseBody
    List<ItemTransactionDto> get() {

        //List<ItemTransactionDto> itemEntities = itemService.get();

        return null;
    }

    @RequestMapping(value = itemTransactionHistoryUri, method = {RequestMethod.PUT})
    public @ResponseBody
    ItemTransactionDto save(ItemTransactionDto item) {

        //ItemTransactionDto saveItemUser = itemTransaction.save(item);

        return null;
    }

    @RequestMapping(value = itemTransactionHistoryUri, method = {RequestMethod.DELETE})
    public @ResponseBody
    void delete(Long itemId) {

        //itemTransaction.delete(itemId);
    }
}
