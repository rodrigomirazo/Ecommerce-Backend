package com.ecommerce.bicicle.mapper;

import com.ecommerce.bicicle.dto.UserDto;
import com.ecommerce.bicicle.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class UserMapper {

    @Autowired
    private UserAddressMapper userAddressMapper;

    public List<UserDto> toUserDtoList(List<UserEntity> users) {
        return users.stream().map(this::toUserDto).collect(Collectors.toList());
    }

    public UserDto toUserDto(UserEntity user) {

        UserDto mappedUser = new UserDto()
                .setId(user.getId())
                .setName(user.getName())
                .setLastname(user.getLastname())
                .setEmail(user.getEmail())
                .setUserName(user.getUserName())
                .setUserProfileImg(user.getUserProfileImg())
                .setPassword(user.getPassword())
                .setCreatedTime(user.getCreatedTime())
                .setUserProfileImg(user.getUserProfileImg())
                .setUserDescription(user.getUserDescription())
                .setContent(user.getContent())
                .setFavorites(user.getFavorites());

        if(user.getUserAddresses() != null) {
            mappedUser.setUserAddresses(userAddressMapper.toUserAddressDtoList(user.getUserAddresses()));
        }

        return mappedUser;
    }

    public List<UserEntity> toUserList(List<UserDto> users) {
        return users.stream().map(this::toUserEntity).collect(Collectors.toList());
    }

    public UserEntity toUserEntity(UserDto user) {

        return new UserEntity()
                .setId(user.getId())
                .setName(user.getName())
                .setLastname(user.getLastname())
                .setEmail(user.getEmail())
                .setUserName(user.getUserName())
                .setPassword(user.getPassword())
                .setCreatedTime(user.getCreatedTime())
                .setUserProfileImg(user.getUserProfileImg())
                .setUserProfileImg(user.getUserProfileImg())
                .setContent(user.getContent())
                .setUserDescription(user.getUserDescription())
                .setFavorites(user.getFavorites());
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

    public UserEntity toUserEntity(Optional<UserEntity> userOptionalEntities) {
        if(!userOptionalEntities.isPresent()) {
            return null;
        }
        return userOptionalEntities.get();
    }

}
