package com.Eclothes.item.service.impl;

import com.Eclothes.item.entity.UserAddress;
import com.Eclothes.item.repository.UserAddressRepository;
import com.Eclothes.item.service.UserAddressService;
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
