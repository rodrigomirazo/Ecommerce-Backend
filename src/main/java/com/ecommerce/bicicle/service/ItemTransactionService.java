package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.dto.ItemTransactionDto;

import java.util.List;

public interface ItemTransactionService {

    ItemTransactionDto getById(Integer itemTransactionId);

    List<ItemTransactionDto> getByUserVendor(String userVendorAccount);

    List<ItemTransactionDto> getByUserBuyer(String userBuyer);

    ItemTransactionDto getByItemIdAndUserBuyer(Integer itemTransactionId, String userBuyerAccount, Integer transactionId);

    ItemTransactionDto getByItemIdAndUserVendor(Integer itemTransactionId, String userBuyerAccount, Integer transactionId);

    ItemTransactionDto save(ItemTransactionDto itemTransaction);
}
