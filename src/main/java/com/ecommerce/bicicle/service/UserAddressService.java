package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.entity.UserAddress;

import java.util.List;

public interface UserAddressService {
    List<UserAddress> get();

    UserAddress save(UserAddress userAddress);

    void delete(Long userAddressId);
}
