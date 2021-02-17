package com.ecommerce.bicicle.controller;

import com.ecommerce.bicicle.constants.EndpointNames;
import com.ecommerce.bicicle.dto.ItemSavedDto;
import com.ecommerce.bicicle.dto.ItemTransactionDto;
import com.ecommerce.bicicle.dto.UserDto;
import com.ecommerce.bicicle.service.ItemTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = EndpointNames.URI)
public class ItemTransactionController {

    private static final String itemTransactionUri = EndpointNames.ITEM_TRANSACTION_CONTROLLER;
    
    @Autowired
    private ItemTransactionService itemTransactionService;

    @RequestMapping(value = itemTransactionUri + "/userBuyer/{userName}", method = {RequestMethod.GET})
    public @ResponseBody
    List<ItemTransactionDto> getByUserBuyer(@PathVariable(value = "userName")  String userName) {

        return itemTransactionService.getByUserBuyer(userName);
    }

    @RequestMapping(value = itemTransactionUri + "/userVendor/{userName}", method = {RequestMethod.GET})
    public @ResponseBody
    List<ItemTransactionDto> getByUserVendor(@PathVariable(value = "userName")  String userName) {

        return itemTransactionService.getByUserVendor(userName);
    }

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

    /*
        Delivery Flow
     */

    @RequestMapping(value = itemTransactionUri + "/{transactionId}/service/{service}", method = {RequestMethod.GET})
    public @ResponseBody
    ItemTransactionDto itemWashAndService(
            @PathVariable(value = "transactionId")  Integer transactionId,
            @PathVariable(value = "service") boolean service
    ) {

        return itemTransactionService.itemWashAndService(transactionId, service);
    }

    @RequestMapping(value = itemTransactionUri + "/{transactionId}/sent/{sent}", method = {RequestMethod.GET})
    public @ResponseBody
    ItemTransactionDto itemSent(
            @PathVariable(value = "transactionId")  Integer transactionId,
            @PathVariable(value = "sent") boolean sent
    ) {

        return itemTransactionService.itemSent(transactionId, sent);
    }

    @RequestMapping(value = itemTransactionUri + "/{transactionId}/receive/{receive}", method = {RequestMethod.GET})
    public @ResponseBody
    ItemTransactionDto itemReceived(
            @PathVariable(value = "transactionId")  Integer transactionId,
            @PathVariable(value = "receive") boolean receive
            ) {

        return itemTransactionService.itemReceived(transactionId, receive);
    }
}
