package com.ecommerce.bicicle.repository;

import com.ecommerce.bicicle.entity.ItemFloatingCharsCatEntity;
import com.ecommerce.bicicle.entity.ItemFloatingCharsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemFloatingCharsCatRepository extends CrudRepository<ItemFloatingCharsCatEntity, Integer> {

    List<ItemFloatingCharsCatEntity> findByItemFloatingChar(ItemFloatingCharsEntity itemFloatingChar);
}
