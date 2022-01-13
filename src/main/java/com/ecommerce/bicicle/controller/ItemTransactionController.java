package com.ecommerce.bicicle.controller;

import com.ecommerce.bicicle.constants.EndpointNames;
import com.ecommerce.bicicle.dto.ItemTransactionDto;
import com.ecommerce.bicicle.service.ItemTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = EndpointNames.URI)
public class ItemTransactionController {

    private static final String itemTransactionUri = EndpointNames.ITEM_TRANSACTION_CONTROLLER;
    
    @Autowired
    private ItemTransactionService itemTransactionService;

    /*
        Shopping
     */
    @RequestMapping(value = itemTransactionUri + "/userBuyer/{userName}", method = {RequestMethod.GET})
    public @ResponseBody
    List<ItemTransactionDto> getByUserBuyer(@PathVariable(value = "userName")  String userName) {

        return itemTransactionService.getByUserBuyer(userName);
    }

    /*
        Sales
     */
    @RequestMapping(value = itemTransactionUri + "/userVendor/{userName}", method = {RequestMethod.GET})
    public @ResponseBody
    List<ItemTransactionDto> getByUserVendor(@PathVariable(value = "userName")  String userName) {

        return itemTransactionService.getByUserVendor(userName);
    }

    /*
        Get By Id
     */
    @RequestMapping(value = itemTransactionUri + "/{transactionId}", method = {RequestMethod.GET})
    public @ResponseBody
    ItemTransactionDto getById(@PathVariable(value = "transactionId")  Integer transactionId) {

        return itemTransactionService.getById(transactionId);
    }

    /*
        Get By Id
    */
    @RequestMapping(value = itemTransactionUri + "/status", method = {RequestMethod.GET})
    public @ResponseBody
    List<ItemTransactionDto> getByStatus(
            @RequestParam() @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam() @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
            @RequestParam(value = "transationStatusB64")  String transationStatusB64
            ) {
        byte[] decodedBytes = Base64.getDecoder().decode(transationStatusB64);
        String transationStatusUnparsed = new String(decodedBytes);

        List<String> transationStatus = Arrays.stream(transationStatusUnparsed.split(",")).collect(Collectors.toList());

        Timestamp tsStart = Timestamp.valueOf(start);
        Timestamp tsEnd = Timestamp.valueOf(end);

        return itemTransactionService.getByStatus(
                transationStatus, tsStart, tsEnd
        );
    }

    /*
        Save
     */
    @RequestMapping(value = itemTransactionUri, method = {RequestMethod.POST})
    public @ResponseBody
    ItemTransactionDto saveItemTranasction(@RequestBody ItemTransactionDto itemTransactionDto) {

        return itemTransactionService.save(itemTransactionDto);
    }

    /*
        Delivery Flow
     */

    // 1. Item Wash And Service
    @RequestMapping(value = itemTransactionUri + "/{transactionId}/service/{service}", method = {RequestMethod.GET})
    public @ResponseBody
    ItemTransactionDto itemWashAndService(
            @PathVariable(value = "transactionId")  Integer transactionId,
            @PathVariable(value = "service") boolean service
    ) {

        return itemTransactionService.itemWashAndService(transactionId, service);
    }

    // 2. Item Sent
    @RequestMapping(value = itemTransactionUri + "/{transactionId}/sent/{sent}", method = {RequestMethod.GET})
    public @ResponseBody
    ItemTransactionDto itemSent(
            @PathVariable(value = "transactionId")  Integer transactionId,
            @PathVariable(value = "sent") boolean sent
    ) {

        return itemTransactionService.itemSent(transactionId, sent);
    }

    // 3. Item Received
    @RequestMapping(value = itemTransactionUri + "/{transactionId}/receive/{receive}", method = {RequestMethod.GET})
    public @ResponseBody
    ItemTransactionDto itemReceived(
            @PathVariable(value = "transactionId")  Integer transactionId,
            @PathVariable(value = "receive") boolean receive
            ) {

        return itemTransactionService.itemReceived(transactionId, receive);
    }

    // 1. Item Wash And Service
    @RequestMapping(value = itemTransactionUri + "/{transactionId}/status/{transactionStatus}/service/{service}/sent/{sent}/receive/{receive}/trackerCompany/{trackerCompany}/trackingNumber/{trackingNumber}", method = {RequestMethod.GET})
    public @ResponseBody
    ItemTransactionDto itemAdminFlow(
            @PathVariable(value = "transactionId")  Integer transactionId,
            @PathVariable(value = "transactionStatus") String transactionStatus,
            @PathVariable(value = "service") boolean service,
            @PathVariable(value = "sent") boolean sent,
            @PathVariable(value = "receive") boolean receive,
            @PathVariable(value = "trackerCompany")  String trackerCompany,
            @PathVariable(value = "trackingNumber") String trackingNumber
            ) {

        return itemTransactionService.itemAdminFlow(
                transactionId, transactionStatus, service, sent, receive, trackerCompany,
                trackingNumber);
    }
}
