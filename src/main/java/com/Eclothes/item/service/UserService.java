package com.Eclothes.item.service;

import com.Eclothes.item.dto.UserDto;
import com.Eclothes.item.entity.UserEntity;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public interface UserService {

    List<UserDto> get();

    UserDto get(Integer userId);

    UserDto save(UserDto user);

    void delete(Integer userId);
}
