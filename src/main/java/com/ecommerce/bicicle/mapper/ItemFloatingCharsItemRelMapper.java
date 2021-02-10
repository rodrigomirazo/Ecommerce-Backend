package com.ecommerce.bicicle.mapper;

import com.ecommerce.bicicle.dto.ItemFloatingCharsRelDto;
import com.ecommerce.bicicle.entity.ItemFloatingCharsCatEntity;
import com.ecommerce.bicicle.entity.ItemFloatingCharsEntity;
import com.ecommerce.bicicle.entity.ItemFloatingCharsRelEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ItemFloatingCharsItemRelMapper {


    public List<ItemFloatingCharsRelDto> toItemFloatingCharsRelDtoList(List<ItemFloatingCharsRelEntity> users) {
        return users.stream().map(this::toItemFloatingCharsRelDto).collect(Collectors.toList());
    }

    public ItemFloatingCharsRelDto toItemFloatingCharsRelDto(ItemFloatingCharsRelEntity itemFloatingCharsRel) {

        return new ItemFloatingCharsRelDto()
                .setFloatingCharCatId(itemFloatingCharsRel.getFloatingCharCatId())
                .setItemFloatingCharsRelId(itemFloatingCharsRel.getItemFloatingCharsRelId())
                .setItemId(itemFloatingCharsRel.getItemId())
                .setFloatingCharId(itemFloatingCharsRel.getFloatingCharId());
    }

    public List<ItemFloatingCharsRelEntity> toItemFloatingCharsRelEntityList(List<ItemFloatingCharsRelDto> itemFloatingCharsRelDtos) {
        return itemFloatingCharsRelDtos.stream().map(this::toItemFloatingCharsRelEntity).collect(Collectors.toList());
    }

    public ItemFloatingCharsRelEntity toItemFloatingCharsRelEntity(ItemFloatingCharsRelDto itemFloatingCharsRel) {

        return new ItemFloatingCharsRelEntity()
                .setItemFloatingCharsRelId(itemFloatingCharsRel.getItemFloatingCharsRelId())
                .setFloatingCharCatId(itemFloatingCharsRel.getFloatingCharCatId())
                .setItemId(itemFloatingCharsRel.getItemId())
                .setFloatingCharId(itemFloatingCharsRel.getFloatingCharId());
    }

    public List<ItemFloatingCharsRelDto> toItemFloatingCharsRelDtoList(Iterable<ItemFloatingCharsRelEntity> floatingCharsIterableEntities) {
        return StreamSupport.stream(
                floatingCharsIterableEntities.spliterator(), true)
                .map(this::toItemFloatingCharsRelDto)
                .collect(Collectors.toList());
    }

    public ItemFloatingCharsRelDto toItemFloatingCharsRelDto(Optional<ItemFloatingCharsRelEntity> itemFloatingCharsRelEntity) {
        if(!itemFloatingCharsRelEntity.isPresent()) {
            return new ItemFloatingCharsRelDto();
        }
        return toItemFloatingCharsRelDto(itemFloatingCharsRelEntity.get());
    }

}
