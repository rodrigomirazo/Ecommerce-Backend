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
                .setName(userEntity.getName())
                .setLastname(userEntity.getLastname())
                .setEmail(userEntity.getEmail())
                .setUserName(userEntity.getUserName())
                .setUserProfileImg(userEntity.getUserProfileImg())
                .setPassword(userEntity.getPassword())
                .setCreatedTime(userEntity.getCreatedTime())
                .setUserProfileImg(userEntity.getUserProfileImg())
                .setUserDescription(userEntity.getUserDescription());
    }

    public List<UserEntity> toUserList(List<UserDto> users) {
        return users.stream().map(this::toUserEntity).collect(Collectors.toList());
    }

    public UserEntity toUserEntity(UserDto userDto) {

        return new UserEntity()
                .setId(userDto.getId())
                .setName(userDto.getName())
                .setLastname(userDto.getLastname())
                .setEmail(userDto.getEmail())
                .setUserName(userDto.getUserName())
                .setPassword(userDto.getPassword())
                .setCreatedTime(userDto.getCreatedTime())
                .setUserProfileImg(userDto.getUserProfileImg())
                .setUserProfileImg(userDto.getUserProfileImg())
                .setUserDescription(userDto.getUserDescription());
    }

    public List<UserEntity> toUserDtoList(Iterable<UserEntity> userIterableEntities) {
        return StreamSupport.stream(
                userIterableEntities.spliterator(), true)
                .collect(Collectors.toList());
    }

    public UserDto toUserDto(Optional<UserEntity> userOptionalEntities) {
        if(!userOptionalEntities.isPresent()) {
            return null;
        }
        return toUserDto(userOptionalEntities.get());
    }

}
