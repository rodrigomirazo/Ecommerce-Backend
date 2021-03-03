package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.dto.ItemTransactionDto;

import java.sql.Timestamp;
import java.util.List;

public interface ItemTransactionService {

    ItemTransactionDto getById(Integer itemTransactionId);

    List<ItemTransactionDto> getByUserVendor(String userVendorAccount);

    List<ItemTransactionDto> getByUserBuyer(String userBuyer);

    ItemTransactionDto getByItemIdAndUserBuyer(Integer itemTransactionId, String userBuyerAccount, Integer transactionId);

    ItemTransactionDto getByItemIdAndUserVendor(Integer itemTransactionId, String userBuyerAccount, Integer transactionId);

    List<ItemTransactionDto> getByStatus(List<String> statusArray, Timestamp startDate, Timestamp endDate);

    ItemTransactionDto save(ItemTransactionDto itemTransaction);

    ItemTransactionDto itemWashAndService(Integer itemTransactionId, boolean service);

    ItemTransactionDto itemAdminFlow(Integer transactionId,
                                     String transactionStatus,
                                     boolean service,
                                     boolean sent,
                                     boolean receive,
                                     String trackerCompany,
                                     String trackingNumber);


    ItemTransactionDto itemSent(Integer itemTransactionId, boolean sent);

    ItemTransactionDto itemReceived(Integer itemTransactionId, boolean receive);
}
