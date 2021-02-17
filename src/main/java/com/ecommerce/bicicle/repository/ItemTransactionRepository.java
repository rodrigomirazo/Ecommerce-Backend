package com.ecommerce.bicicle.repository;

import com.ecommerce.bicicle.entity.ItemEntity;
import com.ecommerce.bicicle.entity.ItemTransactionEntity;
import com.ecommerce.bicicle.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ItemTransactionRepository extends CrudRepository<ItemTransactionEntity, Integer> {

    List<ItemTransactionEntity> findByUserVendorAndTransactionStatusIn(UserEntity userVendor, List<String> transactionStatus);
    List<ItemTransactionEntity> findByUserBuyerAndTransactionStatusIn(UserEntity userBuyer, List<String> transactionStatus);

    ItemTransactionEntity findByIdAndUserBuyerAndItem(Integer id, UserEntity userBuyer, ItemEntity itemEntity);
    ItemTransactionEntity findByIdAndUserVendorAndItem(Integer id, UserEntity userVendor, ItemEntity itemEntity);
}
