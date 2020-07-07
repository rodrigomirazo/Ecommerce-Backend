package com.Eclothes.item.service.impl;

import com.Eclothes.item.entity.ItemComments;
import com.Eclothes.item.repository.ItemCommentsRepository;
import com.Eclothes.item.service.ItemCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ItemCommentsServiceImpl implements ItemCommentsService {

    @Autowired
    ItemCommentsRepository itemCommentsRepository;

    public List<ItemComments> get() {
        return StreamSupport.stream(
                itemCommentsRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public ItemComments save(ItemComments itemComments) {
        return itemCommentsRepository.save(itemComments);
    }

    public void delete(Long id) {
        itemCommentsRepository.deleteById(id);
    }
}
