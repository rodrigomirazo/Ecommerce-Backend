package com.ecommerce.bicicle.repository;

import com.ecommerce.bicicle.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}
