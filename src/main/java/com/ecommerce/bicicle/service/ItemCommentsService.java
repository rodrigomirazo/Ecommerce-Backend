package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.entity.ItemComments;

import java.util.List;

public interface ItemCommentsService {
    List<ItemComments> get();

    ItemComments save(ItemComments itemComments);

    void delete(Long itemCommentsId);
}
