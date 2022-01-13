package com.ecommerce.bicicle.mapper;

import com.ecommerce.bicicle.dto.ItemFloatingCharsCatDto;
import com.ecommerce.bicicle.dto.ItemFloatingCharsDto;
import com.ecommerce.bicicle.entity.ItemFloatingCharsCatEntity;
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

    public ItemFloatingCharsCatDto toItemFloatingCharsCatDto(ItemFloatingCharsCatEntity itemFloatingCharsCat) {

        ItemFloatingCharsDto itemFloatingCharsDto = new ItemFloatingCharsDto();
        itemFloatingCharsDto.setFloatingCharId(itemFloatingCharsCat.getItemFloatingChar().getFloatingCharId());
        itemFloatingCharsDto.setFloatingCharName(itemFloatingCharsCat.getItemFloatingChar().getCharName());

        return new ItemFloatingCharsCatDto()
                .setCharId(itemFloatingCharsCat.getFloatingCharCatId())
                .setCharName(itemFloatingCharsCat.getFloatingCharName());
    }

    public List<ItemFloatingCharsCatEntity> toItemFloatingCharsCatEntityList(List<ItemFloatingCharsCatDto> itemFloatingCharsCatDtos) {
        return itemFloatingCharsCatDtos.stream().map(this::toItemFloatingCharsCatEntity).collect(Collectors.toList());
    }

    public ItemFloatingCharsCatEntity toItemFloatingCharsCatEntity(ItemFloatingCharsCatDto itemFloatingCharsCat) {

        return new ItemFloatingCharsCatEntity()
                .setFloatingCharCatId(itemFloatingCharsCat.getCharId())
                .setFloatingCharName(itemFloatingCharsCat.getCharName());
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
