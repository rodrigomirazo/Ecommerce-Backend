package com.ecommerce.bicicle.mapper;

import com.ecommerce.bicicle.dto.UserAddressDto;
import com.ecommerce.bicicle.entity.UserAddressEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class UserAddressMapper {

    public List<UserAddressDto> toUserAddressDtoList(List<UserAddressEntity> userAddresss) {
        return userAddresss.stream().map(this::toUserAddressDto).collect(Collectors.toList());
    }

    public UserAddressDto toUserAddressDto(UserAddressEntity userAddressEntity) {

        return new UserAddressDto()
                .setId(userAddressEntity.getId())
                .setUserId(userAddressEntity.getUserId())
                .setLastnames(userAddressEntity.getLastnames())
                .setStreet( userAddressEntity.getStreet())
                .setIntNumber( userAddressEntity.getIntNumber())
                .setExtNumber( userAddressEntity.getExtNumber())
                .setZipCode( userAddressEntity.getZipCode())
                .setState( userAddressEntity.getState())
                .setCity( userAddressEntity.getCity())
                .setSuburb( userAddressEntity.getSuburb())
                .setReference( userAddressEntity.getReference())
                .setPhoneNumber( userAddressEntity.getPhoneNumber());
    }

    public List<UserAddressEntity> toUserAddressList(List<UserAddressDto> userAddresss) {
        return userAddresss.stream().map(this::toUserAddressEntity).collect(Collectors.toList());
    }

    public UserAddressEntity toUserAddressEntity(UserAddressDto userAddressDto) {

        return new UserAddressEntity()
                .setId(userAddressDto.getId())
                .setUserId(userAddressDto.getUserId())
                .setLastnames(userAddressDto.getLastnames())
                .setStreet( userAddressDto.getStreet())
                .setIntNumber( userAddressDto.getIntNumber())
                .setExtNumber( userAddressDto.getExtNumber())
                .setZipCode( userAddressDto.getZipCode())
                .setState( userAddressDto.getState())
                .setCity( userAddressDto.getCity())
                .setSuburb( userAddressDto.getSuburb())
                .setReference( userAddressDto.getReference())
                .setPhoneNumber( userAddressDto.getPhoneNumber());
    }

    public List<UserAddressEntity> toUserAddressDtoList(Iterable<UserAddressEntity> userAddressIterableEntities) {
        return StreamSupport.stream(
                userAddressIterableEntities.spliterator(), true)
                .collect(Collectors.toList());
    }

    public UserAddressDto toUserAddressDto(Optional<UserAddressEntity> userAddressOptionalEntities) {
        if(!userAddressOptionalEntities.isPresent()) {
            return null;
        }
        return toUserAddressDto(userAddressOptionalEntities.get());
    }

}
