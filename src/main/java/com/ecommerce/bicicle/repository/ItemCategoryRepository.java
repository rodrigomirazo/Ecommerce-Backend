package com.ecommerce.bicicle.repository;

import com.ecommerce.bicicle.entity.ItemCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemCategoryRepository extends CrudRepository<ItemCategory, Long> {
    List<ItemCategory> findByItemTypeId(Integer itemTypeId);
}
