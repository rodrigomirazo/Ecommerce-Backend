package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.dto.UserAddressDto;
import com.ecommerce.bicicle.entity.UserAddressEntity;

import java.util.List;

public interface UserAddressService {
    List<UserAddressDto> get();

    UserAddressEntity save(UserAddressDto userAddress);

    void delete(String userAddressId);
}
