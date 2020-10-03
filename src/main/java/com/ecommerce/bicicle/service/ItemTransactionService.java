package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.entity.ItemTransaction;

import java.util.List;

public interface ItemTransactionService {
    List<ItemTransaction> get();

    ItemTransaction save(ItemTransaction itemTransaction);

    void delete(Long itemTransactionId);
}
