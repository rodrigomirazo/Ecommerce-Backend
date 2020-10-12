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

    public ItemDto toItemDto(ItemEntity itemEntity) {

        UserDto userDto = userMapper.toUserDto(itemEntity.getUser());

        return new ItemDto()
                .setId(itemEntity.getId())
                .setStatusId(itemEntity.getStatusId())
                .setItemColorId(itemEntity.getItemColorId())
                .setItemTypeCatId(itemEntity.getItemTypeCatId())
                .setItemTransactionId(itemEntity.getItemTransactionId())
                .setName(itemEntity.getName())
                .setPrice(itemEntity.getPrice())
                .setOriginalPrice(itemEntity.getOriginalPrice())
                .setDiscount(itemEntity.getDiscount())
                .setDescription(itemEntity.getDescription())
                .setFleetCost(itemEntity.getFleetCost())
                .setSizeId(itemEntity.getSizeId())
                .setLastLevelCategoryId(itemEntity.getLastLevelCategoryId());
    }

    public List<ItemEntity> toUserList(List<ItemDto> users) {
        return users.stream().map(this::toItemEntity).collect(Collectors.toList());
    }

    public ItemEntity toItemEntity(ItemDto itemDto) {

        return new ItemEntity()
                .setId(itemDto.getId())
                .setStatusId(itemDto.getStatusId())
                .setItemColorId(itemDto.getItemColorId())
                .setItemTypeCatId(itemDto.getItemTypeCatId())
                .setItemTransactionId(itemDto.getItemTransactionId())
                .setName(itemDto.getName())
                .setPrice(itemDto.getPrice())
                .setOriginalPrice(itemDto.getOriginalPrice())
                .setDiscount(itemDto.getDiscount())
                .setDescription(itemDto.getDescription())
                .setFleetCost(itemDto.getFleetCost())
                .setSizeId(itemDto.getSizeId())
                .setLastLevelCategoryId(itemDto.getLastLevelCategoryId());
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
