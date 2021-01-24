package com.ecommerce.bicicle.mapper;

import com.ecommerce.bicicle.dto.ItemTransactionDto;
import com.ecommerce.bicicle.entity.ItemTransactionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ItemTransactionMapper {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserAddressMapper userAddressMapper;

    /** LIST **/
    public List<ItemTransactionEntity> toItemTransactionEntityList(List<ItemTransactionDto> itemTransactionDtos) {
        return itemTransactionDtos.stream().map(this::toItemTransactionEntity).collect(Collectors.toList());
    }
    public List<ItemTransactionDto> toItemTransactionDtoList(List<ItemTransactionEntity> itemImgUrlsEntities) {
        return itemImgUrlsEntities.stream().map(this::toItemTransactionDto).collect(Collectors.toList());
    }

    /** SETTERS & GETTERS **/
    public ItemTransactionDto toItemTransactionDto(ItemTransactionEntity itemTransactionEntity) {

        return new ItemTransactionDto()
                .setId(itemTransactionEntity.getId())
                .setItem( itemMapper.toItemDto( itemTransactionEntity.getItem() ) )
                .setUserVendor( userMapper.toUserDto(itemTransactionEntity.getUserVendor()) )
                .setUserBuyer( userMapper.toUserDto(itemTransactionEntity.getUserBuyer()) )
                .setTransactionStatus( itemTransactionEntity.getTransactionStatus() )
                .setBuyerAddress( userAddressMapper.toUserAddressDto( itemTransactionEntity.getBuyerAddress()))
                .setVendorAddress( userAddressMapper.toUserAddressDto( itemTransactionEntity.getVendorAddress()))
                .setPaymentMethod( itemTransactionEntity.getPaymentMethod() )
                .setTotalPayment( itemTransactionEntity.getTotalPayment() )
                .setTrackingNumber( itemTransactionEntity.getTrackingNumber() )
                .setRate( itemTransactionEntity.getRate() )
                ;
    }

    public ItemTransactionEntity toItemTransactionEntity(ItemTransactionDto itemTransactionDto) {

        return new ItemTransactionEntity()
                .setId(itemTransactionDto.getId())
                .setItem( itemMapper.toItemEntity( itemTransactionDto.getItem() ) )
                .setUserVendor( userMapper.toUserEntity(itemTransactionDto.getUserVendor()) )
                .setUserBuyer( userMapper.toUserEntity(itemTransactionDto.getUserBuyer()) )
                .setTransactionStatus( itemTransactionDto.getTransactionStatus() )
                .setBuyerAddress( userAddressMapper.toUserAddressEntity( itemTransactionDto.getBuyerAddress()))
                .setVendorAddress( userAddressMapper.toUserAddressEntity( itemTransactionDto.getVendorAddress()))
                .setPaymentMethod( itemTransactionDto.getPaymentMethod() )
                .setTotalPayment( itemTransactionDto.getTotalPayment() )
                .setTrackingNumber( itemTransactionDto.getTrackingNumber() )
                .setRate( itemTransactionDto.getRate() );
    }

    /** ITERABLE **/
    public List<ItemTransactionEntity> itemImgIterableToList(Iterable<ItemTransactionEntity> itemImgUrlsEntities) {
        return StreamSupport.stream(
                itemImgUrlsEntities.spliterator(), true)
                .collect(Collectors.toList());
    }
    public List<ItemTransactionDto> itemImgListToIterable(Iterable<ItemTransactionDto> itemImgUrlsEntities) {
        return StreamSupport.stream(
                itemImgUrlsEntities.spliterator(), true)
                .collect(Collectors.toList());
    }

    /** OPTIONALS **/
    public ItemTransactionDto toItemTransactionDto(Optional<ItemTransactionEntity> itemTransactionDto) {
        if(!itemTransactionDto.isPresent()) {
            return new ItemTransactionDto();
        }
        return toItemTransactionDto(itemTransactionDto.get());
    }

}
