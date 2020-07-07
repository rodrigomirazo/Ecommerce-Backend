package com.Eclothes.item.service;

import com.Eclothes.item.entity.ItemTransaction;

import java.util.List;

public interface ItemTransactionService {
    List<ItemTransaction> get();

    ItemTransaction save(ItemTransaction itemTransaction);

    void delete(Long itemTransactionId);
}
