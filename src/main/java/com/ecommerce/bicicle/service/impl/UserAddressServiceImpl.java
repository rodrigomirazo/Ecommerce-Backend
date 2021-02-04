package com.ecommerce.bicicle.service.impl;

import com.ecommerce.bicicle.dto.UserAddressDto;
import com.ecommerce.bicicle.entity.UserAddressEntity;
import com.ecommerce.bicicle.entity.UserEntity;
import com.ecommerce.bicicle.mapper.UserAddressMapper;
import com.ecommerce.bicicle.repository.UserAddressRepository;
import com.ecommerce.bicicle.repository.UserRepository;
import com.ecommerce.bicicle.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    UserAddressRepository userAddressRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserAddressMapper userAddressMapper;

    @Override
    public List<UserAddressDto> get() {


        //userAddressMapper.toUserAddressDtoList(userAddressRepository.findAll());

        return userAddressMapper.toUserAddressDtoList(
                userAddressMapper.toUserAddressDtoList(userAddressRepository.findAll())
                );
    }

    @Override
    public List<UserAddressDto> getByUserName(String userName) {

        Optional<UserEntity> userEntity = userRepository.getByUserName(userName);
        if( !userEntity.isPresent() ) {
            return new ArrayList<>();
        }

        String userId = userEntity.get().getId() + "";
        return userAddressMapper.toUserAddressDtoList(userAddressRepository.getByUserId(userId));
    }

    @Override
    public UserAddressDto save(UserAddressDto userAddress) {
        UserAddressEntity userAddressEntity = userAddressMapper.toUserAddressEntity(userAddress);
        userAddressEntity = userAddressRepository.save(userAddressEntity);
        return userAddressMapper.toUserAddressDto(userAddressEntity);
    }

    @Override
    public void delete(String userAddressId) {
        userAddressRepository.deleteById(Integer.parseInt(userAddressId));
    }
}
