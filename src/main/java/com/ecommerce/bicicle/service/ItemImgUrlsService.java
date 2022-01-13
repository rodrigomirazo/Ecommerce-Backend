package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.entity.ItemImgUrlsEntity;

import java.util.List;

public interface ItemImgUrlsService {
    List<ItemImgUrlsEntity> get();

    ItemImgUrlsEntity save(ItemImgUrlsEntity itemImgUrls);

    void delete(Integer itemImgUrlsId);
}
