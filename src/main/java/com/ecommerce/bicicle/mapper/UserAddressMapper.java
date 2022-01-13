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

    public UserAddressDto toUserAddressDto(UserAddressEntity userAddress) {

        return new UserAddressDto()
                .setId(userAddress.getId())
                .setName(userAddress.getName())
                .setUserId(userAddress.getUserId())
                .setLastnames(userAddress.getLastnames())
                .setStreet( userAddress.getStreet())
                .setStreetRef(userAddress.getStreetRef())
                .setIntNumber( userAddress.getIntNumber())
                .setExtNumber( userAddress.getExtNumber())
                .setZipCode( userAddress.getZipCode())
                .setState( userAddress.getState())
                .setCity( userAddress.getCity())
                .setSuburb( userAddress.getSuburb())
                .setReference( userAddress.getReference())
                .setPhoneNumber( userAddress.getPhoneNumber())
                .setStreetRef( userAddress.getStreetRef() );
    }

    public List<UserAddressEntity> toUserAddressList(List<UserAddressDto> userAddresss) {
        return userAddresss.stream().map(this::toUserAddressEntity).collect(Collectors.toList());
    }

    public UserAddressEntity toUserAddressEntity(UserAddressDto userAddress) {

        return new UserAddressEntity()
                .setId(userAddress.getId())
                .setName(userAddress.getName())
                .setUserId(userAddress.getUserId())
                .setLastnames(userAddress.getLastnames())
                .setStreet( userAddress.getStreet())
                .setStreetRef(userAddress.getStreetRef())
                .setIntNumber( userAddress.getIntNumber())
                .setExtNumber( userAddress.getExtNumber())
                .setZipCode( userAddress.getZipCode())
                .setState( userAddress.getState())
                .setCity( userAddress.getCity())
                .setSuburb( userAddress.getSuburb())
                .setReference( userAddress.getReference())
                .setPhoneNumber( userAddress.getPhoneNumber())
                .setStreetRef( userAddress.getStreetRef() );
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
