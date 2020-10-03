package com.ecommerce.bicicle.mapper;

import com.ecommerce.bicicle.dto.ItemFloatingCharsRelDto;
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

    public ItemFloatingCharsRelDto toItemFloatingCharsRelDto(ItemFloatingCharsRelEntity itemFloatingCharsRelEntity) {

        return new ItemFloatingCharsRelDto()
                .setItemFloatingCharsCatId(itemFloatingCharsRelEntity.getFloatingCharCatId())
                .setItemFloatingCharsRelId(itemFloatingCharsRelEntity.getItemFloatingCharsRelId())
                .setItemId(itemFloatingCharsRelEntity.getItemId());
    }

    public List<ItemFloatingCharsRelEntity> toItemFloatingCharsRelEntityList(List<ItemFloatingCharsRelDto> itemFloatingCharsRelDtos) {
        return itemFloatingCharsRelDtos.stream().map(this::toItemFloatingCharsRelEntity).collect(Collectors.toList());
    }

    public ItemFloatingCharsRelEntity toItemFloatingCharsRelEntity(ItemFloatingCharsRelDto itemFloatingCharsRelDto) {

        return new ItemFloatingCharsRelEntity()
                .setItemFloatingCharsRelId(itemFloatingCharsRelDto.getItemFloatingCharsRelId())
                .setFloatingCharCatId(itemFloatingCharsRelDto.getItemFloatingCharsCatId())
                .setItemId(itemFloatingCharsRelDto.getItemId());
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
