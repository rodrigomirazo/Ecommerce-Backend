package com.Eclothes.item.service;

import com.Eclothes.item.entity.ItemImgUrls;

import java.util.List;

public interface ItemImgUrlsService {
    List<ItemImgUrls> get();

    ItemImgUrls save(ItemImgUrls itemImgUrls);

    void delete(Long itemImgUrlsId);
}
