package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.entity.ItemTransactionHistory;
import java.util.List;

public interface ItemTransactionHistoryService {
    List<ItemTransactionHistory> get();

    ItemTransactionHistory save(ItemTransactionHistory ItemTransaction);

    void delete(Long itemTransactionHistoryId);
}
