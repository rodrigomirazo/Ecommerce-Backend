package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> get();

    List<UserDto> getUserAdmins();

    UserDto get(Integer userId);

    UserDto getByUsername(String userName);

    UserDto getByUsernameAndPassword(String userName, String password);

    UserDto authenticate(UserDto userDto);

    UserDto save(UserDto user);

    void delete(Integer userId);
}
