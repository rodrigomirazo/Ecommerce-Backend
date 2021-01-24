package com.ecommerce.bicicle.service.impl;

import com.ecommerce.bicicle.dto.ItemTransactionDto;
import com.ecommerce.bicicle.entity.UserEntity;
import com.ecommerce.bicicle.mapper.ItemTransactionMapper;
import com.ecommerce.bicicle.mapper.UserMapper;
import com.ecommerce.bicicle.repository.ItemTransactionRepository;
import com.ecommerce.bicicle.repository.UserRepository;
import com.ecommerce.bicicle.service.ItemTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ItemTransactionServiceImpl implements ItemTransactionService {

    @Autowired
    ItemTransactionMapper itemTransactionMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ItemTransactionRepository itemTransRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public ItemTransactionDto getById(Integer itemTransactionId) {

        return itemTransactionMapper.toItemTransactionDto(itemTransRepository.findById(itemTransactionId));
    }

    @Override
    public List<ItemTransactionDto> getByUserVendor(Integer userVendorId) {

        Optional<UserEntity> userOptionalVendor = userRepository.findById(userVendorId);
        if(userOptionalVendor.isPresent()) {
            UserEntity userEntity = userMapper.toUserEntity(userOptionalVendor);

            return itemTransactionMapper.toItemTransactionDtoList(itemTransRepository.findByUserVendor(userEntity));
        }
        return null;
    }

    @Override
    public List<ItemTransactionDto> getByUserBuyer(Integer userBuyerId) {

        Optional<UserEntity> userOptionalBuyer = userRepository.findById(userBuyerId);
        if(userOptionalBuyer.isPresent()) {
            UserEntity userEntity = userMapper.toUserEntity(userOptionalBuyer);

            return itemTransactionMapper.toItemTransactionDtoList(itemTransRepository.findByUserVendor(userEntity));
        }
        return null;
    }

    @Override
    public ItemTransactionDto getByItemId(Integer itemId, Integer userId) {
        return null;
    }

    @Override
    public ItemTransactionDto save(ItemTransactionDto itemTransaction) {
        return null;
    }

    @Override
    public void delete(Integer itemTransactionId) {

    }
}
