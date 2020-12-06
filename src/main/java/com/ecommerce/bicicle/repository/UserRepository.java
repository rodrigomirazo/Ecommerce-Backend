package com.ecommerce.bicicle.repository;

import com.ecommerce.bicicle.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    /**
     * Lookup user by name
     * @param userName
     * @return
     */
    Optional<UserEntity> getByUserName(String userName);

    /**
     * Lookup user by name and Password
     * @param userName
     * @param password
     * @return
     */
    Optional<UserEntity> getByUserNameAndPassword(String userName, String password);

}
