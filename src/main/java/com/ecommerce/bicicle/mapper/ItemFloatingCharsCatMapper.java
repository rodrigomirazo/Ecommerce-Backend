package com.ecommerce.bicicle.mapper;

import com.ecommerce.bicicle.dto.ItemFloatingCharsCatDto;
import com.ecommerce.bicicle.dto.ItemFloatingCharsDto;
import com.ecommerce.bicicle.entity.ItemFloatingCharsCatEntity;
import com.ecommerce.bicicle.entity.ItemFloatingCharsEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ItemFloatingCharsCatMapper {

    public List<ItemFloatingCharsCatDto> toItemFloatingCharsCatDtoList(List<ItemFloatingCharsCatEntity> users) {
        return users.stream().map(this::toItemFloatingCharsCatDto).collect(Collectors.toList());
    }

    public ItemFloatingCharsCatDto toItemFloatingCharsCatDto(ItemFloatingCharsCatEntity itemFloatingCharsCatEntity) {

        ItemFloatingCharsDto itemFloatingCharsDto = new ItemFloatingCharsDto();
        itemFloatingCharsDto.setFloatingCharId(itemFloatingCharsCatEntity.getItemFloatingChar().getFloatingCharId());
        itemFloatingCharsDto.setCharName(itemFloatingCharsCatEntity.getItemFloatingChar().getCharName());

        return new ItemFloatingCharsCatDto()
                .setFloatingCharCatId(itemFloatingCharsCatEntity.getFloatingCharCatId())
                .setFloatingCharName(itemFloatingCharsCatEntity.getFloatingCharName())
                .setItemFloatingChar(itemFloatingCharsDto);
    }

    public List<ItemFloatingCharsCatEntity> toItemFloatingCharsCatEntityList(List<ItemFloatingCharsCatDto> itemFloatingCharsCatDtos) {
        return itemFloatingCharsCatDtos.stream().map(this::toItemFloatingCharsCatEntity).collect(Collectors.toList());
    }

    public ItemFloatingCharsCatEntity toItemFloatingCharsCatEntity(ItemFloatingCharsCatDto itemFloatingCharsCatDto) {

        ItemFloatingCharsEntity itemFloatingCharsEntity = new ItemFloatingCharsEntity();
        itemFloatingCharsEntity.setFloatingCharId(itemFloatingCharsCatDto.getItemFloatingChar().getFloatingCharId());
        itemFloatingCharsEntity.setCharName(itemFloatingCharsCatDto.getItemFloatingChar().getCharName());

        return new ItemFloatingCharsCatEntity()
                .setFloatingCharCatId(itemFloatingCharsCatDto.getFloatingCharCatId())
                .setFloatingCharName(itemFloatingCharsCatDto.getFloatingCharName())
                .setItemFloatingChar(itemFloatingCharsEntity);
    }

    public List<ItemFloatingCharsCatDto> toItemFloatingCharsCatDtoList(Iterable<ItemFloatingCharsCatEntity> floatingCharsIterableEntities) {
        return StreamSupport.stream(
                floatingCharsIterableEntities.spliterator(), true)
                .map(this::toItemFloatingCharsCatDto)
                .collect(Collectors.toList());
    }

    public ItemFloatingCharsCatDto toItemFloatingCharsCatDto(Optional<ItemFloatingCharsCatEntity> itemFloatingCharsCatEntity) {
        if(!itemFloatingCharsCatEntity.isPresent()) {
            return new ItemFloatingCharsCatDto();
        }
        return toItemFloatingCharsCatDto(itemFloatingCharsCatEntity.get());
    }

}
