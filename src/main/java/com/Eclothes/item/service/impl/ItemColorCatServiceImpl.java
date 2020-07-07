package com.Eclothes.item.service.impl;

import com.Eclothes.item.entity.ItemColorCat;
import com.Eclothes.item.repository.ItemColorCatRepository;
import com.Eclothes.item.service.ItemColorCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ItemColorCatServiceImpl implements ItemColorCatService {

    @Autowired
    ItemColorCatRepository itemColorCatRepository;

    public List<ItemColorCat> get() {
        return StreamSupport.stream(
                itemColorCatRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public ItemColorCat save(ItemColorCat itemColorCat) {
        return itemColorCatRepository.save(itemColorCat);
    }

    public void delete(Long id) {
        itemColorCatRepository.deleteById(id);
    }
}
