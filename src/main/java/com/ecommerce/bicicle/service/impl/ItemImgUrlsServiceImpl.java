package com.ecommerce.bicicle.service.impl;

import com.ecommerce.bicicle.entity.ItemImgUrlsEntity;
import com.ecommerce.bicicle.repository.ItemImgUrlsRepository;
import com.ecommerce.bicicle.service.ItemImgUrlsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ItemImgUrlsServiceImpl implements ItemImgUrlsService {

    @Autowired
    ItemImgUrlsRepository itemImgUrlsRepo;

    @Override
    public List<ItemImgUrlsEntity> get() {
        return StreamSupport.stream(
                itemImgUrlsRepo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public ItemImgUrlsEntity save(ItemImgUrlsEntity itemImgUrls) {
        return itemImgUrlsRepo.save(itemImgUrls);
    }

    @Override
    public void delete(Integer itemImgUrlsId) {
        itemImgUrlsRepo.deleteById(itemImgUrlsId);
    }
}
