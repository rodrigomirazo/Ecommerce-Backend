package com.ecommerce.bicicle.controller;

import com.ecommerce.bicicle.constants.EndpointNames;
import com.ecommerce.bicicle.dto.ItemSavedDto;
import com.ecommerce.bicicle.dto.ItemTransactionDto;
import com.ecommerce.bicicle.service.ItemTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transaction;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = EndpointNames.URI)
public class ItemTransactionController {

    private static final String itemTransactionUri = EndpointNames.ITEM_TRANSACTION_CONTROLLER;
    
    @Autowired
    private ItemTransactionService itemTransactionService;

    @RequestMapping(value = itemTransactionUri, method = {RequestMethod.GET})
    public @ResponseBody
    ItemTransactionDto getByItemIdandUserId(Integer itemId, Integer userId) {

        return itemTransactionService.getByItemId(itemId, userId);
    }

    @RequestMapping(value = itemTransactionUri, method = {RequestMethod.PUT})
    public @ResponseBody
    ItemTransactionDto getItem(ItemTransactionDto itemTransactionDto) {

        ItemTransactionDto saveItemUser = itemTransactionService.save(itemTransactionDto);

        return saveItemUser;
    }

    @RequestMapping(value = itemTransactionUri, method = {RequestMethod.DELETE})
    public @ResponseBody
    void getItem(Integer transactionId) {

        itemTransactionService.delete(transactionId);
    }
}
