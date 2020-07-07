package com.Eclothes.item.service.impl;

import com.Eclothes.item.entity.ItemImgUrls;
import com.Eclothes.item.repository.ItemImgUrlsRepository;
import com.Eclothes.item.service.ItemImgUrlsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ItemImgUrlsServiceImpl implements ItemImgUrlsService {

    @Autowired
    ItemImgUrlsRepository itemImgUrlsRepo;

    @Override
    public List<ItemImgUrls> get() {
        return StreamSupport.stream(
                itemImgUrlsRepo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public ItemImgUrls save(ItemImgUrls itemImgUrls) {
        return itemImgUrlsRepo.save(itemImgUrls);
    }

    @Override
    public void delete(Long itemImgUrlsId) {
        itemImgUrlsRepo.deleteById(itemImgUrlsId);
    }
}
