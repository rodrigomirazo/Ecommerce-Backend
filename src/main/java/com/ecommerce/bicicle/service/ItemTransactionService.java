package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.dto.ItemTransactionDto;

import java.util.List;

public interface ItemTransactionService {

    ItemTransactionDto getById(Integer itemTransactionId);

    List<ItemTransactionDto> getByUserVendor(Integer userVendorId);

    List<ItemTransactionDto> getByUserBuyer(Integer userBuyerId);

    ItemTransactionDto getByItemId(Integer itemTransactionId, Integer userId);

    ItemTransactionDto save(ItemTransactionDto itemTransaction);

    void delete(Integer itemTransactionId);
}
