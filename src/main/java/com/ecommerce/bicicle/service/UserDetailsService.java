package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.dto.UserDto;

public interface UserDetailsService {

    UserDto loadUserByUsername(String username) throws Exception;
}
