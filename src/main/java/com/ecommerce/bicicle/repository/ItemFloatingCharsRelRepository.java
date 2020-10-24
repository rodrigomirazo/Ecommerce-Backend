package com.ecommerce.bicicle.repository;

import com.ecommerce.bicicle.entity.ItemFloatingCharsRelEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemFloatingCharsRelRepository  extends CrudRepository<ItemFloatingCharsRelEntity, Integer> {

    List<ItemFloatingCharsRelEntity> findByItemId(Integer itemId);
}
