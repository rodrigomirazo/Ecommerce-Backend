package com.Eclothes.item.repository;

import com.Eclothes.item.entity.ItemCategory;
import com.Eclothes.item.entity.ItemTransaction;
import org.springframework.data.repository.CrudRepository;

public interface ItemTransactionRepository extends CrudRepository<ItemTransaction, Long> {

}
