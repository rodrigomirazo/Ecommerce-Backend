package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> get();

    UserDto get(Integer userId);

    UserDto getByUsername(String userName);

    UserDto save(UserDto user);

    void delete(Integer userId);
}
