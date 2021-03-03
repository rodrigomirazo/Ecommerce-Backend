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
    private ItemSaveFloatingCharsMapper itemMapper;

    @Autowired
    private ItemTransactionHistoryMapper itemTransactionHistoryMapper;

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
    public ItemTransactionDto toItemTransactionDto(ItemTransactionEntity itemTransaction) {

        return new ItemTransactionDto()
                .setId(itemTransaction.getId())
                .setItem( itemMapper.toItemSaveDto( itemTransaction.getItem() ) )
                .setUserVendor( userMapper.toUserDto(itemTransaction.getUserVendor()) )
                .setUserBuyer( userMapper.toUserDto(itemTransaction.getUserBuyer()) )
                .setTransactionStatus( itemTransaction.getTransactionStatus() )
                .setBuyerAddress( userAddressMapper.toUserAddressDto( itemTransaction.getBuyerAddress()))
                .setVendorAddress( userAddressMapper.toUserAddressDto( itemTransaction.getVendorAddress()))
                .setPaymentMethod( itemTransaction.getPaymentMethod() )
                .setTotalPayment( itemTransaction.getTotalPayment() )
                .setTrackingNumber( itemTransaction.getTrackingNumber() )
                .setTrackerCompany( itemTransaction.getTrackerCompany() )
                .setRate( itemTransaction.getRate() )
                .setItemTransactionHistory( itemTransactionHistoryMapper.toItemTransactionHistoryDtoList( itemTransaction.getItemTransactionHistory()))
                .setCreatedTime(itemTransaction.getCreatedTime())
                .setService(itemTransaction.getService())
                .setServiceTime(itemTransaction.getServiceTime())
                .setSent(itemTransaction.getSent())
                .setSentTime(itemTransaction.getSentTime())
                .setRecieved(itemTransaction.getRecieved())
                .setRecievedTime(itemTransaction.getRecievedTime())
                ;
    }

    public ItemTransactionEntity toItemTransactionEntity(ItemTransactionDto itemTransaction) {

        return new ItemTransactionEntity()
                .setId(itemTransaction.getId())
                .setItem( itemMapper.toItemEntity( itemTransaction.getItem() ) )
                .setUserVendor( userMapper.toUserEntity(itemTransaction.getUserVendor()) )
                .setUserBuyer( userMapper.toUserEntity(itemTransaction.getUserBuyer()) )
                .setTransactionStatus( itemTransaction.getTransactionStatus() )
                .setBuyerAddress( userAddressMapper.toUserAddressEntity( itemTransaction.getBuyerAddress()))
                .setVendorAddress( userAddressMapper.toUserAddressEntity( itemTransaction.getVendorAddress()))
                .setPaymentMethod( itemTransaction.getPaymentMethod() )
                .setTotalPayment( itemTransaction.getTotalPayment() )
                .setTrackingNumber( itemTransaction.getTrackingNumber() )
                .setTrackerCompany( itemTransaction.getTrackerCompany() )
                .setRate( itemTransaction.getRate() )
                .setItemTransactionHistory( itemTransactionHistoryMapper.toItemTransactionHistoryEntityList( itemTransaction.getItemTransactionHistory()))
                .setCreatedTime(itemTransaction.getCreatedTime())
                .setService(itemTransaction.getService())
                .setServiceTime(itemTransaction.getServiceTime())
                .setSent(itemTransaction.getSent())
                .setSentTime(itemTransaction.getSentTime())
                .setRecieved(itemTransaction.getRecieved())
                .setRecievedTime(itemTransaction.getRecievedTime())
                ;
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
