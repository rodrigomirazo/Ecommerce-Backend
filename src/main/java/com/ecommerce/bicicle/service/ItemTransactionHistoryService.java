package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.entity.ItemTransactionHistoryEntity;
import java.util.List;

public interface ItemTransactionHistoryService {
    List<ItemTransactionHistoryEntity> get();

    ItemTransactionHistoryEntity save(ItemTransactionHistoryEntity ItemTransaction);

    void delete(Long itemTransactionHistoryId);
}
