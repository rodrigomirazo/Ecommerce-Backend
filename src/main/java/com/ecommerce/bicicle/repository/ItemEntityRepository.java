package com.ecommerce.bicicle.repository;

import com.ecommerce.bicicle.entity.ItemEntity;
import com.ecommerce.bicicle.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemEntityRepository extends CrudRepository<ItemEntity, Integer> {

    List<ItemEntity> findByItemTypeCatId(int itemTypeCatId);
    List<ItemEntity> findByUser(UserEntity user);


}
