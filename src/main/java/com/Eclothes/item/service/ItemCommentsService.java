package com.Eclothes.item.service;

import com.Eclothes.item.entity.ItemComments;

import java.util.List;

public interface ItemCommentsService {
    List<ItemComments> get();

    ItemComments save(ItemComments itemComments);

    void delete(Long itemCommentsId);
}
