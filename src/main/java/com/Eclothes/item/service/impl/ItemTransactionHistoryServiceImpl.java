package com.Eclothes.item.service.impl;

import com.Eclothes.item.entity.ItemTransaction;
import com.Eclothes.item.entity.ItemTransactionHistory;
import com.Eclothes.item.repository.ItemTransactionHistoryRepository;
import com.Eclothes.item.service.ItemTransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ItemTransactionHistoryServiceImpl implements ItemTransactionHistoryService {

    @Autowired
    ItemTransactionHistoryRepository itemTransHistRepo;

    @Override
    public List<ItemTransactionHistory> get() {
        return StreamSupport.stream(
                itemTransHistRepo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public ItemTransactionHistory save(ItemTransactionHistory itemTransactionHistory) {
        return itemTransHistRepo.save(itemTransactionHistory);
    }

    @Override
    public void delete(Long itemTransactionHistId) {
        itemTransHistRepo.deleteById(itemTransactionHistId);
    }
}
