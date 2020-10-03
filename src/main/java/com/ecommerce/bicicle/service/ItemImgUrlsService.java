package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.entity.ItemImgUrls;

import java.util.List;

public interface ItemImgUrlsService {
    List<ItemImgUrls> get();

    ItemImgUrls save(ItemImgUrls itemImgUrls);

    void delete(Long itemImgUrlsId);
}
