package com.ecommerce.bicicle.service.impl;

import com.ecommerce.bicicle.dto.UserAddressDto;
import com.ecommerce.bicicle.entity.UserAddressEntity;
import com.ecommerce.bicicle.mapper.UserAddressMapper;
import com.ecommerce.bicicle.repository.UserAddressRepository;
import com.ecommerce.bicicle.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    UserAddressRepository userAddressRepository;

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
    public UserAddressEntity save(UserAddressDto userAddress) {

        return null;//userAddressRepository.save(userAddress);
    }

    @Override
    public void delete(String userAddressId) {
        userAddressRepository.deleteById(Integer.parseInt(userAddressId));
    }
}
