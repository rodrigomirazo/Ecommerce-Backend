package com.ecommerce.bicicle.controller;

import com.ecommerce.bicicle.constants.EndpointNames;
import com.ecommerce.bicicle.dto.ItemSavedDto;
import com.ecommerce.bicicle.dto.ItemTransactionDto;
import com.ecommerce.bicicle.dto.UserDto;
import com.ecommerce.bicicle.service.ItemTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = EndpointNames.URI)
public class ItemTransactionController {

    private static final String itemTransactionUri = EndpointNames.ITEM_TRANSACTION_CONTROLLER;
    
    @Autowired
    private ItemTransactionService itemTransactionService;

    @RequestMapping(value = itemTransactionUri + "/{transactionId}", method = {RequestMethod.GET})
    public @ResponseBody
    ItemTransactionDto getById(@PathVariable(value = "transactionId")  Integer transactionId) {

        return itemTransactionService.getById(transactionId);
    }

    @RequestMapping(value = itemTransactionUri, method = {RequestMethod.POST})
    public @ResponseBody
    ItemTransactionDto saveItemTranasction(@RequestBody ItemTransactionDto itemTransactionDto) {

        return itemTransactionService.save(itemTransactionDto);
    }
}
