package com.Eclothes.item.service;

import com.Eclothes.item.entity.ItemTransactionHistory;
import java.util.List;

public interface ItemTransactionHistoryService {
    List<ItemTransactionHistory> get();

    ItemTransactionHistory save(ItemTransactionHistory ItemTransaction);

    void delete(Long itemTransactionHistoryId);
}
