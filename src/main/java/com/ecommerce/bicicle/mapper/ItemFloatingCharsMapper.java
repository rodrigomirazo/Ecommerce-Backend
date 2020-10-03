package com.ecommerce.bicicle.mapper;

import com.ecommerce.bicicle.dto.ItemFloatingCharsDto;
import com.ecommerce.bicicle.entity.ItemFloatingCharsEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ItemFloatingCharsMapper {

    public List<ItemFloatingCharsDto> toItemFloatingCharsDtoList(List<ItemFloatingCharsEntity> users) {
        return users.stream().map(this::toItemFloatingCharsDto).collect(Collectors.toList());
    }

    public ItemFloatingCharsDto toItemFloatingCharsDto(ItemFloatingCharsEntity itemFloatingCharsEntity) {

        return new ItemFloatingCharsDto()
                .setCharName(itemFloatingCharsEntity.getCharName())
                .setFloatingCharId(itemFloatingCharsEntity.getFloatingCharId());
    }

    public List<ItemFloatingCharsEntity> toItemFloatingCharsEntityList(List<ItemFloatingCharsDto> itemFloatingCharsDtos) {
        return itemFloatingCharsDtos.stream().map(this::toItemFloatingCharsEntity).collect(Collectors.toList());
    }

    public ItemFloatingCharsEntity toItemFloatingCharsEntity(ItemFloatingCharsDto itemFloatingCharsDto) {

        return new ItemFloatingCharsEntity()
                .setCharName(itemFloatingCharsDto.getCharName())
                .setFloatingCharId(itemFloatingCharsDto.getFloatingCharId());
    }

    public List<ItemFloatingCharsDto> toItemFloatingCharsDtoList(Iterable<ItemFloatingCharsEntity> floatingCharsIterableEntities) {
        return StreamSupport.stream(
                floatingCharsIterableEntities.spliterator(), true)
                .map(this::toItemFloatingCharsDto)
                .collect(Collectors.toList());
    }

    public ItemFloatingCharsDto toItemFloatingCharsDto(Optional<ItemFloatingCharsEntity> itemFloatingCharsEntity) {
        if(!itemFloatingCharsEntity.isPresent()) {
            return new ItemFloatingCharsDto();
        }
        return toItemFloatingCharsDto(itemFloatingCharsEntity.get());
    }

}
