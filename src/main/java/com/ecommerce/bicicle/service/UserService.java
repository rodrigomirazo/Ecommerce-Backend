package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.dto.ItemSavedDto;
import com.ecommerce.bicicle.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> get();

    List<UserDto> getUserAdmins();

    UserDto get(Integer userId);

    UserDto getByUsername(String userName);

    UserDto getByUsernameAndPassword(String userName, String password);

    UserDto getByUsernameAndPassword(String userName, String password, Boolean userVerified);

    UserDto getByUsernameAndPasswordCrossPlatform(String userName, String password);

    UserDto authenticate(UserDto userDto);

    UserDto save(UserDto user);

    UserDto saveCrossPlatform(UserDto user);

    UserDto registerUser(UserDto user);

    UserDto enableUser(UserDto user);

    UserDto savePassword(UserDto user);

    List<ItemSavedDto> getFavouriteItems(String userName);

    List<ItemSavedDto> addFavouriteItems(String userName, Integer itemId);

    List<ItemSavedDto> removeFavouriteItems(String userName, Integer itemId);

    void delete(Integer userId);
}
