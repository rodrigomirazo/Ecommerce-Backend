package com.ecommerce.bicicle.repository;

import com.ecommerce.bicicle.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    /**
     *
     * @param userName
     * @return
     */
    Optional<UserEntity> getByUserName(String userName);
}
