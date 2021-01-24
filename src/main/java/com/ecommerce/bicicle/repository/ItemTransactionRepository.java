package com.ecommerce.bicicle.repository;

import com.ecommerce.bicicle.entity.ItemTransactionEntity;
import com.ecommerce.bicicle.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ItemTransactionRepository extends CrudRepository<ItemTransactionEntity, Integer> {
    List<ItemTransactionEntity> findByUserVendor(UserEntity userVendor);
    List<ItemTransactionEntity> findByUserBuyer(UserEntity userBuyer);
}
