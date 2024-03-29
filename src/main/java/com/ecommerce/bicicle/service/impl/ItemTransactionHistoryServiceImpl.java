package com.ecommerce.bicicle.service.impl;

import com.ecommerce.bicicle.entity.ItemTransactionHistoryEntity;
import com.ecommerce.bicicle.repository.ItemTransactionHistoryRepository;
import com.ecommerce.bicicle.service.ItemTransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ItemTransactionHistoryServiceImpl implements ItemTransactionHistoryService {

    @Autowired
    ItemTransactionHistoryRepository itemTransHistRepo;

    @Override
    public List<ItemTransactionHistoryEntity> get() {
        return StreamSupport.stream(
                itemTransHistRepo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public ItemTransactionHistoryEntity save(ItemTransactionHistoryEntity itemTransactionHistory) {
        return itemTransHistRepo.save(itemTransactionHistory);
    }

    @Override
    public void delete(Long itemTransactionHistId) {
        itemTransHistRepo.deleteById(itemTransactionHistId);
    }
}
