package com.ecommerce.bicicle.repository;

import com.ecommerce.bicicle.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
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

    /**
     * Lookup user by name and Password
     * @param userName
     * @param password
     * @return
     */
    Optional<UserEntity> getByUserNameAndPasswordAndUserVerified(String userName, String password, Boolean userVerified);

    /**
     * Lookup user by name and Password
     * @param userName
     * @param uid
     * @return
     */
    Optional<UserEntity> getByUserNameAndUid(String userName, String uid);

    /**
     * Lookup user by Profile COntent
     * @param content
     * @return
     */
    List<UserEntity> getByContent(String content);

}
