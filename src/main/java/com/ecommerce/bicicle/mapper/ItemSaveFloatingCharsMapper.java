package com.ecommerce.bicicle.mapper;

import com.ecommerce.bicicle.dto.*;
import com.ecommerce.bicicle.entity.ItemEntity;
import com.ecommerce.bicicle.entity.ItemFloatingCharsRelEntity;
import com.ecommerce.bicicle.service.FloatingCharsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ItemSaveFloatingCharsMapper {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ItemSaveMapper itemSaveMapper;

    @Autowired
    private ItemImgUrlMapper itemImgUrlMapper;

    @Autowired
    private FloatingCharsService floatingCharsService;

    List<ItemFloatingCharsDto> itemFloatingChars;

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
                        crossFloatingChars(item)
                        /*
                        item.getItemFloatingCharsRel().stream().map(itemFloatingChars ->

                                new FloatingCharsRelDto()
                                        .setFloatingCharId(itemFloatingChars.getFloatingCharId())
                                        .setFloatingCharCatId(itemFloatingChars.getFloatingCharCatId())

                    ).collect(Collectors.toList())
                        */
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

    private String crossItemType(ItemEntity itemEntity) {
        ItemSavedDto itemSavedDto = itemSaveMapper.toItemSaveDto(itemEntity);

        return "";
    }

    private List<FloatingCharsRelDto> crossFloatingChars(ItemEntity itemEntity) {

        this.itemFloatingChars = this.floatingCharsService.getItemFloatingCharsDtos();
        ItemSavedDto itemSavedDto = itemSaveMapper.toItemSaveDto(itemEntity);
        List<FloatingCharsRelDto> floatingCharsCROSSED = new ArrayList<>();

        itemSavedDto.getItemFloatingChars().forEach(floatCharsList -> {

            List<ItemFloatingCharsDto> floatingCharFilterList =
            this.itemFloatingChars.stream().filter(floatingChar ->
                    floatingChar.getFloatingCharId() == floatCharsList.getFloatingCharId()
            ).collect(Collectors.toList());

            ItemFloatingCharsDto floatingCharFilter = floatingCharFilterList.get(0);

            List<ItemFloatingCharsCatDto> itemFloatingCharsCatList =
            floatingCharFilter.getCatalogList().stream().filter(
                    itemFloatingCharsCat -> itemFloatingCharsCat.getCharId() == floatCharsList.getFloatingCharCatId()
            ).collect(Collectors.toList());

            ItemFloatingCharsCatDto itemFloatingCharsCatDto = new ItemFloatingCharsCatDto();
            if(itemFloatingCharsCatList.size() > 0) {
                itemFloatingCharsCatDto = itemFloatingCharsCatList.get(0);
                floatCharsList.setFloatingCharName( itemFloatingCharsCatDto.getCharName() );
                floatCharsList.setFloatingCharCatName( floatingCharFilter.getFloatingCharName() );
            }

            floatingCharsCROSSED.add(floatCharsList);

        });

        return floatingCharsCROSSED;
    }

    public List<ItemEntity> toItemSaveDtoList(Iterable<ItemEntity> userIterableEntities) {
        return StreamSupport.stream(
                userIterableEntities.spliterator(), true)
                .collect(Collectors.toList());
    }

    public Page<ItemSavedDto> toItemSaveDtoPage(Page<ItemEntity> userIterableEntities) {

        List<ItemSavedDto> list =
        userIterableEntities.stream().map(itemEntity -> toItemSaveDto(itemEntity)).collect(Collectors.toList());

        return new PageImpl<>(list);
    }

    public List<ItemSavedDto> toItemSaveDtoList(Page<ItemEntity> userIterableEntities) {

        List<ItemSavedDto> list =
                userIterableEntities.stream().map(itemEntity -> toItemSaveDto(itemEntity)).collect(Collectors.toList());

        return list;
    }

    public ItemSavedDto toItemSaveDto(Optional<ItemEntity> userOptionalEntities) {
        if(!userOptionalEntities.isPresent()) {
            return new ItemSavedDto();
        }
        return toItemSaveDto(userOptionalEntities.get());
    }

}
