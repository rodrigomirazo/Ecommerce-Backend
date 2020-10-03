package com.ecommerce.bicicle.repository;

import com.ecommerce.bicicle.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<ItemEntity, Long> {
    List<ItemEntity> findByItemTypeCatId(int itemTypeCatId);
}
