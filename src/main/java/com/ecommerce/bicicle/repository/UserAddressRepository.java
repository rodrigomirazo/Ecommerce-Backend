package com.ecommerce.bicicle.repository;

import com.ecommerce.bicicle.entity.UserAddressEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserAddressRepository extends CrudRepository<UserAddressEntity, Integer> {
    List<UserAddressEntity> getByUserId(String userId);
}
