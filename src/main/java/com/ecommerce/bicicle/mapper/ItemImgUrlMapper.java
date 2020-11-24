package com.ecommerce.bicicle.mapper;

import com.ecommerce.bicicle.dto.ItemImgUrlsDto;
import com.ecommerce.bicicle.entity.ItemImgUrlsEntity;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ItemImgUrlMapper {

    /** LIST **/
    public List<ItemImgUrlsEntity> toItemImgUrlsEntityList(List<ItemImgUrlsDto> itemImgUrlsDtos) {
        return itemImgUrlsDtos.stream().map(this::toItemImgUrlsEntity).collect(Collectors.toList());
    }
    public List<ItemImgUrlsDto> toItemImgUrlsDtoList(List<ItemImgUrlsEntity> itemImgUrlsEntities) {
        return itemImgUrlsEntities.stream().map(this::toItemImgUrlsDto).collect(Collectors.toList());
    }

    /** SETTERS & GETTERS **/
    public ItemImgUrlsDto toItemImgUrlsDto(ItemImgUrlsEntity itemImgUrlsEntity) {

        return new ItemImgUrlsDto()
                .setId(itemImgUrlsEntity.getId())
                .setItemId(itemImgUrlsEntity.getItemId())
                .setImgUrl(itemImgUrlsEntity.getImgUrl())
                .setCreatedTime(itemImgUrlsEntity.getCreatedTime())
                .setImgServer(itemImgUrlsEntity.getImgServer());
    }
    public ItemImgUrlsEntity toItemImgUrlsEntity(ItemImgUrlsDto itemImgUrlsDto) {

        return new ItemImgUrlsEntity()
                .setId(itemImgUrlsDto.getId())
                .setItemId(itemImgUrlsDto.getItemId())
                .setImgUrl(itemImgUrlsDto.getImgUrl())
                .setCreatedTime(itemImgUrlsDto.getCreatedTime())
                .setImgServer(itemImgUrlsDto.getImgServer());
    }

    /** ITERABLE **/
    public List<ItemImgUrlsEntity> itemImgIterableToList(Iterable<ItemImgUrlsEntity> itemImgUrlsEntities) {
        return StreamSupport.stream(
                itemImgUrlsEntities.spliterator(), true)
                .collect(Collectors.toList());
    }
    public List<ItemImgUrlsDto> itemImgListToIterable(Iterable<ItemImgUrlsDto> itemImgUrlsEntities) {
        return StreamSupport.stream(
                itemImgUrlsEntities.spliterator(), true)
                .collect(Collectors.toList());
    }

    /** OPTIONALS **/
    public ItemImgUrlsDto toItemImgUrlsDto(Optional<ItemImgUrlsEntity> itemImgUrlsDto) {
        if(!itemImgUrlsDto.isPresent()) {
            return new ItemImgUrlsDto();
        }
        return toItemImgUrlsDto(itemImgUrlsDto.get());
    }

}
