package com.Eclothes.item.mapper;

import com.Eclothes.item.dto.UserDto;
import com.Eclothes.item.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
                .setUserProfileImg(userEntity.getUserProfileImg());
    }

    public List<UserEntity> toUserList(List<UserDto> users) {
        return users.stream().map(this::toUserEntity).collect(Collectors.toList());
    }

    public UserEntity toUserEntity(UserDto userEntity) {

        return new UserEntity()
                .setId(userEntity.getId())
                .setEmail(userEntity.getEmail())
                .setUsername(userEntity.getUsername())
                .setUserProfileImg(userEntity.getUserProfileImg());
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
