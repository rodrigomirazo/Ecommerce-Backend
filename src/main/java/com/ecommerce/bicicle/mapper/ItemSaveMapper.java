package com.ecommerce.bicicle.mapper;

import com.ecommerce.bicicle.dto.FloatingCharsRelDto;
import com.ecommerce.bicicle.dto.ItemSavedDto;
import com.ecommerce.bicicle.dto.UserDto;
import com.ecommerce.bicicle.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ItemSaveMapper {
    
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ItemImgUrlMapper itemImgUrlMapper;

    public List<ItemSavedDto> toItemSaveDtoList(List<ItemEntity> users) {
        return users.stream().map(this::toItemSaveDto).collect(Collectors.toList());
    }

    public ItemSavedDto toItemSaveDto(ItemEntity itemEntity) {

        UserDto userDto = userMapper.toUserDto(itemEntity.getUser());

        return new ItemSavedDto()
                .setId(itemEntity.getId())
                .setStatusId(itemEntity.getStatusId())
                .setItemColorId(itemEntity.getItemColorId())
                .setItemTypeCatId(itemEntity.getItemTypeCatId())
                .setItemTransactionId(itemEntity.getItemTransactionId())
                .setName(itemEntity.getName())
                .setYear(itemEntity.getYear())
                .setPrice(itemEntity.getPrice())
                .setOriginalPrice(itemEntity.getOriginalPrice())
                .setDiscount(itemEntity.getDiscount())
                .setDescription(itemEntity.getDescription())
                .setFleetCost(itemEntity.getFleetCost())
                .setSizeId(itemEntity.getSizeId())
                .setLastLevelCategoryId(itemEntity.getLastLevelCategoryId())
                .setUser(userDto)
                .setBackRear(itemEntity.getBackRear())
                .setModel(itemEntity.getModel())
                .setSuspension(itemEntity.getSuspension())
                .setRuedos(itemEntity.getRuedos())
                .setCasette(itemEntity.getCasette())
                .setSeries(itemEntity.getSeries())
                .setGearLevel(itemEntity.getGearLevel())
                .setMultiplication(itemEntity.getMultiplication())
                .setIsModified(itemEntity.getIsModified())
                .setComments(itemEntity.getComments())
                .setFrameRate(itemEntity.getFrameRate())
                .setRuedosRate(itemEntity.getRuedosRate())
                .setWheelsRate(itemEntity.getWheelsRate())
                .setComponentsRate(itemEntity.getComponentsRate())
                .setItemImgUrls( itemImgUrlMapper.toItemImgUrlsDtoList(itemEntity.getItemImgUrls()))
                .setItemFloatingChars(
                        itemEntity.getItemFloatingCharsRel().stream().map(itemFloatingChars ->

                                new FloatingCharsRelDto()
                                        .setFloatingCharId(itemFloatingChars.getFloatingCharId())
                                        .setFloatingCharCatId(itemFloatingChars.getFloatingCharCatId())

                    ).collect(Collectors.toList())
                );
    }

    public List<ItemEntity> toUserList(List<ItemSavedDto> users) {
        return users.stream().map(this::toItemEntity).collect(Collectors.toList());
    }

    public ItemEntity toItemEntity(ItemSavedDto itemSaveDto) {

        return new ItemEntity()
                .setId(itemSaveDto.getId())
                .setStatusId(itemSaveDto.getStatusId())
                .setItemColorId(itemSaveDto.getItemColorId())
                .setItemTypeCatId(itemSaveDto.getItemTypeCatId())
                .setItemTransactionId(itemSaveDto.getItemTransactionId())
                .setName(itemSaveDto.getName())
                .setYear(itemSaveDto.getYear())
                .setPrice(itemSaveDto.getPrice())
                .setOriginalPrice(itemSaveDto.getOriginalPrice())
                .setDiscount(itemSaveDto.getDiscount())
                .setDescription(itemSaveDto.getDescription())
                .setFleetCost(itemSaveDto.getFleetCost())
                .setSizeId(itemSaveDto.getSizeId())
                .setBackRear(itemSaveDto.getBackRear())
                .setModel(itemSaveDto.getModel())
                .setSuspension(itemSaveDto.getSuspension())
                .setRuedos(itemSaveDto.getRuedos())
                .setCasette(itemSaveDto.getCasette())
                .setSeries(itemSaveDto.getSeries())
                .setGearLevel(itemSaveDto.getGearLevel())
                .setMultiplication(itemSaveDto.getMultiplication())
                .setIsModified(itemSaveDto.getIsModified())
                .setComments(itemSaveDto.getComments())
                .setFrameRate(itemSaveDto.getFrameRate())
                .setRuedosRate(itemSaveDto.getRuedosRate())
                .setWheelsRate(itemSaveDto.getWheelsRate())
                .setComponentsRate(itemSaveDto.getComponentsRate())
                .setLastLevelCategoryId(itemSaveDto.getLastLevelCategoryId())
                .setUser(userMapper.toUserEntity(itemSaveDto.getUser()))
                .setItemImgUrls( itemImgUrlMapper.toItemImgUrlsEntityList(itemSaveDto.getItemImgUrls()))
                .setItemFloatingCharsRel(
                        itemSaveDto.getItemFloatingChars().stream().map(floatChar ->
                            new ItemFloatingCharsRelEntity()
                                    .setItemId(itemSaveDto.getId())
                                    .setFloatingCharId(floatChar.getFloatingCharId())
                                    .setFloatingCharCatId(floatChar.getFloatingCharCatId())
                        ).collect(Collectors.toList())
                );
    }

    public List<ItemEntity> toItemSaveDtoList(Iterable<ItemEntity> userIterableEntities) {
        return StreamSupport.stream(
                userIterableEntities.spliterator(), true)
                .collect(Collectors.toList());
    }

    public ItemSavedDto toItemSaveDto(Optional<ItemEntity> userOptionalEntities) {
        if(!userOptionalEntities.isPresent()) {
            return new ItemSavedDto();
        }
        return toItemSaveDto(userOptionalEntities.get());
    }

}
