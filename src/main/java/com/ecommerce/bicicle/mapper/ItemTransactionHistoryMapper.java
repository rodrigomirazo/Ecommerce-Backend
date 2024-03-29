package com.ecommerce.bicicle.mapper;

import com.ecommerce.bicicle.dto.ItemTransactionHistoryDto;
import com.ecommerce.bicicle.entity.ItemTransactionHistoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ItemTransactionHistoryMapper {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserAddressMapper userAddressMapper;

    /** LIST **/
    public List<ItemTransactionHistoryEntity> toItemTransactionHistoryEntityList(List<ItemTransactionHistoryDto> itemTransactionHistoryDtos) {
        return itemTransactionHistoryDtos.stream().map(this::toItemTransactionHistoryEntity).collect(Collectors.toList());
    }
    public List<ItemTransactionHistoryDto> toItemTransactionHistoryDtoList(List<ItemTransactionHistoryEntity> itemImgUrlsEntities) {
        return itemImgUrlsEntities.stream().map(this::toItemTransactionHistoryDto).collect(Collectors.toList());
    }

    /** SETTERS & GETTERS **/
    public ItemTransactionHistoryDto toItemTransactionHistoryDto(ItemTransactionHistoryEntity itemTransactionHistory) {

        return new ItemTransactionHistoryDto()
                .setId(itemTransactionHistory.getId())
                .setItemTransactionId(itemTransactionHistory.getItemTransactionId())
                .setAction(itemTransactionHistory.getAction())
                .setDescription(itemTransactionHistory.getDescription())
                .setCreatedTime(itemTransactionHistory.getCreatedTime())
                ;
    }

    public ItemTransactionHistoryEntity toItemTransactionHistoryEntity(ItemTransactionHistoryDto itemTransactionHistory) {

        return new ItemTransactionHistoryEntity()
                .setId(itemTransactionHistory.getId())
                .setItemTransactionId(itemTransactionHistory.getItemTransactionId())
                .setAction(itemTransactionHistory.getAction())
                .setDescription(itemTransactionHistory.getDescription())
                .setCreatedTime(itemTransactionHistory.getCreatedTime());
    }

    /** ITERABLE **/
    public List<ItemTransactionHistoryEntity> itemImgIterableToList(Iterable<ItemTransactionHistoryEntity> itemImgUrlsEntities) {
        return StreamSupport.stream(
                itemImgUrlsEntities.spliterator(), true)
                .collect(Collectors.toList());
    }
    public List<ItemTransactionHistoryDto> itemImgListToIterable(Iterable<ItemTransactionHistoryDto> itemImgUrlsEntities) {
        return StreamSupport.stream(
                itemImgUrlsEntities.spliterator(), true)
                .collect(Collectors.toList());
    }

    /** OPTIONALS **/
    public ItemTransactionHistoryDto toItemTransactionHistoryDto(Optional<ItemTransactionHistoryEntity> itemTransactionHistoryDto) {
        if(!itemTransactionHistoryDto.isPresent()) {
            return new ItemTransactionHistoryDto();
        }
        return toItemTransactionHistoryDto(itemTransactionHistoryDto.get());
    }

}
