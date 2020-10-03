package com.ecommerce.bicicle.mapper;

import com.ecommerce.bicicle.dto.UserDto;
import com.ecommerce.bicicle.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class UserMapper {

    public List<UserDto> toUserDtoList(List<UserEntity> users) {
        return users.stream().map(this::toUserDto).collect(Collectors.toList());
    }

    public UserDto toUserDto(UserEntity userEntity) {

        return new UserDto()
                .setId(userEntity.getId())
                .setEmail(userEntity.getEmail())
                .setUsername(userEntity.getUsername())
                .setUserProfileImg(userEntity.getUserProfileImg())
                .setPassword(userEntity.getPassword())
                .setCreatedTime(userEntity.getCreatedTime());
    }

    public List<UserEntity> toUserList(List<UserDto> users) {
        return users.stream().map(this::toUserEntity).collect(Collectors.toList());
    }

    public UserEntity toUserEntity(UserDto userDto) {

        return new UserEntity()
                .setId(userDto.getId())
                .setEmail(userDto.getEmail())
                .setUsername(userDto.getUsername())
                .setPassword(userDto.getPassword())
                .setCreatedTime(userDto.getCreatedTime())
                .setUserProfileImg(userDto.getUserProfileImg());
    }

    public List<UserEntity> toUserDtoList(Iterable<UserEntity> userIterableEntities) {
        return StreamSupport.stream(
                userIterableEntities.spliterator(), true)
                .collect(Collectors.toList());
    }

    public UserDto toUserDto(Optional<UserEntity> userOptionalEntities) {
        if(!userOptionalEntities.isPresent()) {
            return new UserDto();
        }
        return toUserDto(userOptionalEntities.get());
    }

}
