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

    public ItemSavedDto toItemSaveDto(ItemEntity item) {

        UserDto userDto = userMapper.toUserDto(item.getUser());

        return new ItemSavedDto()
                .setId(item.getId())
                .setStatusId(item.getStatusId())
                .setItemColorId(item.getItemColorId())
                .setItemTypeCatId(item.getItemTypeCatId())
                .setItemTransactionId(item.getItemTransactionId())
                .setName(item.getName())
                .setYear(item.getYear())
                .setPrice(item.getPrice())
                .setOriginalPrice(item.getOriginalPrice())
                .setDiscount(item.getDiscount())
                .setDescription(item.getDescription())
                .setFleetCost(item.getFleetCost())
                .setSizeId(item.getSizeId())
                .setLastLevelCategoryId(item.getLastLevelCategoryId())
                .setUser(userDto)
                .setBackRear(item.getBackRear())
                .setFrontRear(item.getFrontRear())
                .setModel(item.getModel())
                .setSuspension(item.getSuspension())
                .setBackSuspension(item.getBackSuspension())
                .setRuedos(item.getRuedos())
                .setCassette(item.getCassette())
                .setSeries(item.getSeries())
                .setGearLevel(item.getGearLevel())
                .setMultiplication(item.getMultiplication())
                .setIsModified(item.getIsModified())
                .setComments(item.getComments())
                .setFrameRate(item.getFrameRate())
                .setRuedosRate(item.getRuedosRate())
                .setWheelsRate(item.getWheelsRate())
                .setComponentsRate(item.getComponentsRate())
                .setItemImgUrls( itemImgUrlMapper.toItemImgUrlsDtoList(item.getItemImgUrls()))
                .setItemFloatingChars(
                        item.getItemFloatingCharsRel().stream().map(itemFloatingChars ->

                                new FloatingCharsRelDto()
                                        .setFloatingCharId(itemFloatingChars.getFloatingCharId())
                                        .setFloatingCharCatId(itemFloatingChars.getFloatingCharCatId())

                    ).collect(Collectors.toList())
                )
                .setCreatedTime(item.getCreatedTime())
                .setPaymentConfirmed(item.getPaymentConfirmed())
                .setDiagnostApproved(item.getDiagnostApproved())
                .setDiagnostTime(item.getDiagnostTime())
                .setDiagnostComments(item.getDiagnostComments())
                ;
    }

    public List<ItemEntity> toUserList(List<ItemSavedDto> users) {
        return users.stream().map(this::toItemEntity).collect(Collectors.toList());
    }

    public ItemEntity toItemEntity(ItemSavedDto item) {

        return new ItemEntity()
                .setId(item.getId())
                .setStatusId(item.getStatusId())
                .setItemColorId(item.getItemColorId())
                .setItemTypeCatId(item.getItemTypeCatId())
                .setItemTransactionId(item.getItemTransactionId())
                .setName(item.getName())
                .setYear(item.getYear())
                .setPrice(item.getPrice())
                .setOriginalPrice(item.getOriginalPrice())
                .setDiscount(item.getDiscount())
                .setDescription(item.getDescription())
                .setFleetCost(item.getFleetCost())
                .setSizeId(item.getSizeId())
                .setBackRear(item.getBackRear())
                .setFrontRear(item.getFrontRear())
                .setModel(item.getModel())
                .setSuspension(item.getSuspension())
                .setBackSuspension(item.getBackSuspension())
                .setRuedos(item.getRuedos())
                .setCassette(item.getCassette())
                .setSeries(item.getSeries())
                .setGearLevel(item.getGearLevel())
                .setMultiplication(item.getMultiplication())
                .setIsModified(item.getIsModified())
                .setComments(item.getComments())
                .setFrameRate(item.getFrameRate())
                .setRuedosRate(item.getRuedosRate())
                .setWheelsRate(item.getWheelsRate())
                .setComponentsRate(item.getComponentsRate())
                .setLastLevelCategoryId(item.getLastLevelCategoryId())
                .setUser(userMapper.toUserEntity(item.getUser()))
                .setItemImgUrls( itemImgUrlMapper.toItemImgUrlsEntityList(item.getItemImgUrls()))
                .setItemFloatingCharsRel(
                        item.getItemFloatingChars().stream().map(floatChar ->
                            new ItemFloatingCharsRelEntity()
                                    .setItemId(item.getId())
                                    .setFloatingCharId(floatChar.getFloatingCharId())
                                    .setFloatingCharCatId(floatChar.getFloatingCharCatId())


                        ).collect(Collectors.toList())
                )
                .setCreatedTime(item.getCreatedTime())
                .setPaymentConfirmed(item.getPaymentConfirmed())
                .setDiagnostApproved(item.getDiagnostApproved())
                .setDiagnostTime(item.getDiagnostTime())
                .setDiagnostComments(item.getDiagnostComments())
                ;
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
