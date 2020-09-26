package com.Eclothes.item.service.impl;

import com.Eclothes.item.dto.UserDto;
import com.Eclothes.item.entity.UserEntity;
import com.Eclothes.item.mapper.UserMapper;
import com.Eclothes.item.repository.UserRepository;
import com.Eclothes.item.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> get() {

        Iterable<UserEntity> userEntities = userRepository.findAll();

        List<UserEntity> userEntitiesList = userMapper.toUserDtoList(userEntities);

        return userMapper.toUserDtoList(userEntitiesList);
    }

    @Override
    public UserDto get(Integer userId) {
        Optional<UserEntity> userEntities = userRepository.findById(userId);

        UserDto userDto = userMapper.toUserDto(userEntities);

        return userDto;
    }

    @Override
    public UserDto save(UserDto user) {

        UserEntity userEntity = userRepository.save(userMapper.toUserEntity(user));

        return userMapper.toUserDto(userEntity);
    }

    @Override
    public void delete(Integer userId) {
        userRepository.deleteById(userId);
    }
}
