package com.ecommerce.bicicle.mapper;

import com.ecommerce.bicicle.dto.ItemDto;
import com.ecommerce.bicicle.dto.UserDto;
import com.ecommerce.bicicle.entity.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class UserItemMapper {
    
    @Autowired
    private UserMapper userMapper;

    public List<ItemDto> toItemDtoList(List<ItemEntity> users) {
        return users.stream().map(this::toItemDto).collect(Collectors.toList());
    }

    public ItemDto toItemDto(ItemEntity item) {

        UserDto userDto = userMapper.toUserDto(item.getUser());

        return new ItemDto()
                .setId(item.getId())
                .setStatusId(item.getStatusId())
                .setItemColorId(item.getItemColorId())
                .setItemTypeCatId(item.getItemTypeCatId())
                .setItemTransactionId(item.getItemTransactionId())
                .setName(item.getName())
                .setPrice(item.getPrice())
                .setOriginalPrice(item.getOriginalPrice())
                .setDiscount(item.getDiscount())
                .setDescription(item.getDescription())
                .setFleetCost(item.getFleetCost())
                .setSizeId(item.getSizeId())
                .setLastLevelCategoryId(item.getLastLevelCategoryId());
    }

    public List<ItemEntity> toUserList(List<ItemDto> users) {
        return users.stream().map(this::toItemEntity).collect(Collectors.toList());
    }

    public ItemEntity toItemEntity(ItemDto item) {

        return new ItemEntity()
                .setId(item.getId())
                .setStatusId(item.getStatusId())
                .setItemColorId(item.getItemColorId())
                .setItemTypeCatId(item.getItemTypeCatId())
                .setItemTransactionId(item.getItemTransactionId())
                .setName(item.getName())
                .setPrice(item.getPrice())
                .setOriginalPrice(item.getOriginalPrice())
                .setDiscount(item.getDiscount())
                .setDescription(item.getDescription())
                .setFleetCost(item.getFleetCost())
                .setSizeId(item.getSizeId())
                .setLastLevelCategoryId(item.getLastLevelCategoryId());
    }

    public List<ItemEntity> toItemDtoList(Iterable<ItemEntity> userIterableEntities) {
        return StreamSupport.stream(
                userIterableEntities.spliterator(), true)
                .collect(Collectors.toList());
    }

    public ItemDto toItemDto(Optional<ItemEntity> userOptionalEntities) {
        if(!userOptionalEntities.isPresent()) {
            return new ItemDto();
        }
        return toItemDto(userOptionalEntities.get());
    }

}
