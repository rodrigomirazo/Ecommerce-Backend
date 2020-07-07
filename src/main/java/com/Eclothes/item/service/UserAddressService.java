package com.Eclothes.item.service;

import com.Eclothes.item.entity.UserAddress;

import java.util.List;

public interface UserAddressService {
    List<UserAddress> get();

    UserAddress save(UserAddress userAddress);

    void delete(Long userAddressId);
}
