package com.Eclothes.item.service.impl;

import com.Eclothes.item.entity.ItemTransaction;
import com.Eclothes.item.repository.ItemTransactionRepository;
import com.Eclothes.item.service.ItemTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ItemTransactionServiceImpl implements ItemTransactionService {
    @Autowired
    ItemTransactionRepository itemTransRepository;

    @Override
    public List<ItemTransaction> get() {
        return StreamSupport.stream(
                itemTransRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public ItemTransaction save(ItemTransaction itemTransaction) {
        return itemTransRepository.save(itemTransaction);
    }

    @Override
    public void delete(Long itemTransactionId) {
        itemTransRepository.deleteById(itemTransactionId);
    }
}
