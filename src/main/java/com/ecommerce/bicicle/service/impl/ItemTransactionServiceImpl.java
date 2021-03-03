package com.ecommerce.bicicle.service.impl;

import com.ecommerce.bicicle.constants.TransactionStatus;
import com.ecommerce.bicicle.dto.ItemFloatingCharsDto;
import com.ecommerce.bicicle.dto.ItemTransactionDto;
import com.ecommerce.bicicle.dto.UserAddressDto;
import com.ecommerce.bicicle.entity.*;
import com.ecommerce.bicicle.mapper.ItemTransactionMapper;
import com.ecommerce.bicicle.mapper.UserAddressMapper;
import com.ecommerce.bicicle.mapper.UserMapper;
import com.ecommerce.bicicle.repository.ItemEntityRepository;
import com.ecommerce.bicicle.repository.ItemTransactionRepository;
import com.ecommerce.bicicle.repository.UserAddressRepository;
import com.ecommerce.bicicle.repository.UserRepository;
import com.ecommerce.bicicle.service.FloatingCharsService;
import com.ecommerce.bicicle.service.ItemTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class ItemTransactionServiceImpl implements ItemTransactionService {

    @Autowired
    ItemTransactionMapper itemTransactionMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserAddressMapper userAddressMapper;

    @Autowired
    ItemTransactionRepository itemTransRepository;

    @Autowired
    ItemEntityRepository itemRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserAddressRepository userAddressRepository;

    @Autowired
    FloatingCharsService floatingCharsService;

    @Override
    public ItemTransactionDto getById(Integer itemTransactionId) {

        return itemTransactionMapper.toItemTransactionDto(itemTransRepository.findById(itemTransactionId));
    }

    @Override
    public List<ItemTransactionDto> getByUserVendor(String userVendorAccount) {

        Optional<UserEntity> userOptionalVendor = userRepository.getByUserName(userVendorAccount);
        if(userOptionalVendor.isPresent()) {
            UserEntity userEntity = userMapper.toUserEntity(userOptionalVendor);

            List<ItemFloatingCharsDto> floatingCharsDtos = floatingCharsService.getItemFloatingCharsDtos();

            List<ItemTransactionDto> itemTransactionDtos = itemTransactionMapper.toItemTransactionDtoList(
                    itemTransRepository.findByUserVendorAndTransactionStatusIn(userEntity, shoppingTransaction())
            );
            return itemTransactionDtos;
        }
        return new ArrayList<>();
    }

    @Override
    public List<ItemTransactionDto> getByUserBuyer(String userBuyer) {

        Optional<UserEntity> userOptionalBuyer = userRepository.getByUserName(userBuyer);
        if(userOptionalBuyer.isPresent()) {
            UserEntity userEntity = userMapper.toUserEntity(userOptionalBuyer);

            List<ItemTransactionDto> itemTransactionDtos  = itemTransactionMapper.toItemTransactionDtoList(
                    itemTransRepository.findByUserBuyerAndTransactionStatusIn(userEntity, shoppingTransaction())
            );
            return itemTransactionDtos;
        }
        return new ArrayList<>();
    }

    private List<String> shoppingTransaction() {
        List<String> statusList = new ArrayList<>();
        statusList.add(TransactionStatus.TRANSACT_STATUS_CLIENT_AUTHORIZATION);
        statusList.add(TransactionStatus.TRANSACT_STATUS_SERVICED_COMPLETED);
        statusList.add(TransactionStatus.TRANSACT_STATUS_SENT_TO_BUYER);
        statusList.add(TransactionStatus.TRANSACT_STATUS_RECEIVED_TO_BUYER);

        return statusList;
    }

    @Override
    public ItemTransactionDto getByItemIdAndUserBuyer(Integer itemId, String userBuyerAccount, Integer transactionId) {
        Optional<UserEntity> userOptionalBuyer = userRepository.getByUserName(userBuyerAccount);
        if(userOptionalBuyer.isPresent()) {

            Optional<ItemEntity> itemEntity = itemRepository.findById(itemId);
            if(itemEntity.isPresent()) {
                ItemTransactionEntity itemTransactionEntity = itemTransRepository.findByIdAndUserBuyerAndItem(transactionId, userOptionalBuyer.get(), itemEntity.get());
                return itemTransactionMapper.toItemTransactionDto(itemTransactionEntity);
            }
        }
        return new ItemTransactionDto();
    }

    @Override
    public ItemTransactionDto getByItemIdAndUserVendor(Integer itemId, String userVendorAccount, Integer transactionId) {
        Optional<UserEntity> userOptionalBuyer = userRepository.getByUserName(userVendorAccount);
        if(userOptionalBuyer.isPresent()) {

            Optional<ItemEntity> itemEntity = itemRepository.findById(itemId);
            if(itemEntity.isPresent()) {
                ItemTransactionEntity itemTransactionEntity = itemTransRepository.findByIdAndUserVendorAndItem(transactionId, userOptionalBuyer.get(), itemEntity.get());
                return itemTransactionMapper.toItemTransactionDto(itemTransactionEntity);
            }
        }
        return new ItemTransactionDto();
    }

    @Override
    public List<ItemTransactionDto> getByStatus(List<String> statusArray, Timestamp startDate, Timestamp endDate) {

        List<ItemTransactionDto> itemTransactionDtos  = itemTransactionMapper.toItemTransactionDtoList(
                itemTransRepository.findByTransactionStatusInAndCreatedTimeBetween(statusArray, startDate, endDate)
        );
        return itemTransactionDtos;
    }

    @Override
    public ItemTransactionDto save(ItemTransactionDto itemTransaction) {

        // Transaction Attributes
        UserEntity userEntityBuyer;
        UserEntity userEntityVendor;
        UserAddressEntity userBuyerAdress;
        UserAddressEntity userVendorAdress;

        //User Validations
        try {
            Optional<UserEntity> userOptional = userRepository.getByUserName(itemTransaction.getUserBuyer().getUserName());
            if(userOptional.isPresent()) {
                userEntityBuyer = userOptional.get();
            } else {
                System.out.println("User Buyer not found in Database");
                return new ItemTransactionDto();
            }
        } catch (NullPointerException ne) {
            System.out.println("User Buyer Not defined at reuqest level");
            return new ItemTransactionDto();
        }
        try {
            Optional<UserEntity> userOptional = userRepository.findById(itemTransaction.getUserVendor().getId());
            if(userOptional.isPresent()) {
                userEntityVendor = userOptional.get();
            } else {
                System.out.println("User Vendor not found in Database");
                return new ItemTransactionDto();
            }
        } catch (NullPointerException ne) {
            System.out.println("User Vendor Not defined at reuqest level");
            return new ItemTransactionDto();
        }

        //Address Validations
        try {
            UserAddressDto userAddressDto = itemTransaction.getBuyerAddress();
            try {
                userBuyerAdress = userAddressMapper.toUserAddressEntity(userAddressDto);
            } catch (NullPointerException nu) {
                userAddressDto.setSavedInProfile(false);
                userBuyerAdress = userAddressRepository.save(userAddressMapper.toUserAddressEntity(userAddressDto));
            }
        } catch (NullPointerException ne) {
            System.out.println("User Buyer Not defined at reuqest level");
        }
        try {
            UserAddressDto userAddressDto = itemTransaction.getVendorAddress();
            try {
                userVendorAdress = userAddressMapper.toUserAddressEntity(userAddressDto);
            } catch (NullPointerException nu) {
                userAddressDto.setSavedInProfile(false);
                userVendorAdress = userAddressRepository.save(userAddressMapper.toUserAddressEntity(userAddressDto));
            }
        } catch (NullPointerException ne) {
            System.out.println("User Buyer Not defined at reuqest level");
        }

        //Steps to Save Transaction
        // 1. Convert to Entity
        ItemTransactionEntity itemTransactionEntity = itemTransactionMapper.toItemTransactionEntity(itemTransaction);

        // 2. Set Users
        itemTransactionEntity.setUserBuyer(userEntityBuyer);
        itemTransactionEntity.setUserVendor(userEntityVendor);

        // 3. Set Adresses
        ItemTransactionHistoryEntity itemTransactionHistory = itemTransactionEntity.getItemTransactionHistory().get(0);
        if(itemTransactionEntity.getItemTransactionHistory().get(0).getItemTransactionId().equals(-1)) {
            itemTransactionEntity.setItemTransactionHistory(null);
        } else {
            Timestamp timestamp = new Timestamp(new java.util.Date().getTime());
            itemTransactionHistory.setCreatedTime(timestamp);
        }

        if(itemTransaction.getTransactionStatus().equals(TransactionStatus.TRANSACT_STATUS_CLIENT_AUTHORIZATION)) {
            Timestamp createdTime = new Timestamp(new Date().getTime());
            itemTransactionEntity.setCreatedTime(createdTime);
        }
        ItemTransactionEntity itemTransactionEntityResp = itemTransRepository.save(itemTransactionEntity);
        itemTransactionEntityResp.getItem().setUser(itemTransactionEntityResp.getUserVendor());

        //

        if(itemTransactionEntity.getItemTransactionHistory() == null) {
            Timestamp timestamp = new Timestamp(new java.util.Date().getTime());
            itemTransactionHistory.setCreatedTime(timestamp);
            itemTransactionHistory.setItemTransactionId(itemTransactionEntityResp.getId());
            List<ItemTransactionHistoryEntity> historyDtos = new ArrayList<>();
            historyDtos.add(itemTransactionHistory);
            itemTransactionEntity.setItemTransactionHistory(historyDtos);
            itemTransactionEntity.setItemTransactionHistory(historyDtos);
            itemTransactionEntityResp = itemTransRepository.save(itemTransactionEntity);
        }

        if(itemTransaction.getTransactionStatus().equals(TransactionStatus.TRANSACT_STATUS_CLIENT_AUTHORIZATION)) {
            ItemEntity itemEntity = itemTransactionEntityResp.getItem().setPaymentConfirmed(true);
            itemEntity = itemRepository.save(itemEntity);

            itemTransactionEntityResp.setItem(itemEntity);
        }

        ItemTransactionDto itemTransactionDto = itemTransactionMapper.toItemTransactionDto(itemTransactionEntityResp);

        return itemTransactionDto;
    }

    /*
        Delivery Flow
     */

    @Override
    public ItemTransactionDto itemAdminFlow(Integer itemTransactionId,
                                            String transactionStatus,
                                            boolean service,
                                            boolean sent,
                                            boolean receive,
                                            String trackerCompany,
                                            String trackingNumber) {

        ItemTransactionEntity itemEntity = itemTransRepository.findById(itemTransactionId).get();

        ItemTransactionHistoryEntity itemTransactionHistory = new ItemTransactionHistoryEntity();
        Timestamp timestamp = new Timestamp(new java.util.Date().getTime());
        itemTransactionHistory.setCreatedTime(timestamp);
        itemTransactionHistory.setItemTransactionId(itemEntity.getId());
        itemTransactionHistory.setAction(transactionStatus);
        itemTransactionHistory.setDescription("set " + transactionStatus + " from admin console");

        List<ItemTransactionHistoryEntity> hist =
        itemEntity.getItemTransactionHistory();
        hist.add(itemTransactionHistory);

        // Adding transaction history state
        itemEntity.setItemTransactionHistory(hist);

        // Set Status
        itemEntity.setTransactionStatus(transactionStatus);

        // Set Service
        itemEntity.setService(service);
        itemEntity.setServiceTime(getTimeStamp());

        // Set Received
        itemEntity.setRecieved(receive);
        itemEntity.setRecievedTime(getTimeStamp());

        // Set Sent
        itemEntity.setSent(sent);
        itemEntity.setSentTime(getTimeStamp());

        // Set Company
        itemEntity.setTrackerCompany(trackerCompany);

        // Set Tracking number
        itemEntity.setTrackingNumber(trackingNumber);

        // Save
        itemEntity = itemTransRepository.save(itemEntity);
        return itemTransactionMapper.toItemTransactionDto(itemEntity);
    }

    public ItemTransactionDto itemWashAndService(Integer itemTransactionId, boolean service) {

        ItemTransactionEntity itemEntity = itemTransRepository.findById(itemTransactionId).get();
        itemEntity.setService(service);
        itemEntity.setServiceTime(getTimeStamp());

        itemEntity = itemTransRepository.save(itemEntity);
        return itemTransactionMapper.toItemTransactionDto(itemEntity);
    }

    public ItemTransactionDto itemSent(Integer itemTransactionId, boolean sent) {

        ItemTransactionEntity itemEntity = itemTransRepository.findById(itemTransactionId).get();
        itemEntity.setSent(sent);
        itemEntity.setSentTime(getTimeStamp());

        itemEntity = itemTransRepository.save(itemEntity);
        return itemTransactionMapper.toItemTransactionDto(itemEntity);
    }

    public ItemTransactionDto itemReceived(Integer itemTransactionId, boolean receive) {

        ItemTransactionEntity itemEntity = itemTransRepository.findById(itemTransactionId).get();
        itemEntity.setRecieved(receive);
        itemEntity.setRecievedTime(getTimeStamp());

        itemEntity = itemTransRepository.save(itemEntity);
        return itemTransactionMapper.toItemTransactionDto(itemEntity);
    }

    private Timestamp getTimeStamp() {

        Calendar cal = Calendar.getInstance();
        return new Timestamp(cal.toInstant().toEpochMilli());
    }
}
