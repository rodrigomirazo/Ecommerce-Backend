package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.dto.UserAddressDto;

import java.util.List;

public interface UserAddressService {
    List<UserAddressDto> get();

    List<UserAddressDto> getByUserName(String userName);

    UserAddressDto save(UserAddressDto userAddress);

    void delete(String userAddressId);
}
