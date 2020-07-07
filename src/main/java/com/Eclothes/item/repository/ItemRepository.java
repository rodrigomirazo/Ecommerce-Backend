package com.Eclothes.item.repository;

import com.Eclothes.item.entity.Item;
import com.Eclothes.item.entity.ItemTypeCat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findByItemTypeCatId(int itemTypeCatId);
}
