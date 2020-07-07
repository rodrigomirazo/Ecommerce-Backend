package com.Eclothes.item.repository;

import com.Eclothes.item.entity.ItemCategory;
import com.Eclothes.item.entity.ItemTransactionHistory;
import org.springframework.data.repository.CrudRepository;

public interface ItemTransactionHistoryRepository extends CrudRepository<ItemTransactionHistory, Long> {

}
