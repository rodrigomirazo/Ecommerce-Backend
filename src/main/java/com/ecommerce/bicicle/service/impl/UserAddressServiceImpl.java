package com.ecommerce.bicicle.service.impl;

import com.ecommerce.bicicle.entity.UserAddress;
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

    @Override
    public List<UserAddress> get() {
        return StreamSupport.stream(
                userAddressRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public UserAddress save(UserAddress userAddress) {
        return userAddressRepository.save(userAddress);
    }

    @Override
    public void delete(Long userAddressId) {
        userAddressRepository.deleteById(userAddressId);
    }
}
