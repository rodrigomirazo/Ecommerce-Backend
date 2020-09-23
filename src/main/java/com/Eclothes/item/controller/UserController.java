package com.Eclothes.item.controller;

import com.Eclothes.item.constants.EndpointNames;
import com.Eclothes.item.dto.UserDto;
import com.Eclothes.item.entity.UserEntity;
import com.Eclothes.item.mapper.UserMapper;
import com.Eclothes.item.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = EndpointNames.URI)
public class UserController {

    private static final String userUri = EndpointNames.USER_CONTROLLER;
    

    @Autowired
    private UserService userService;

    @RequestMapping(value = userUri, method = {RequestMethod.GET})
    public @ResponseBody
    List<UserDto> get() {

        List<UserDto> itemEntities = userService.get();

        return itemEntities;
    }

    @RequestMapping(value = userUri, method = {RequestMethod.PUT})
    public @ResponseBody
    UserDto put(UserDto userDto) {

        UserDto savedItemUser = userService.save(userDto);

        return savedItemUser;
    }

    @RequestMapping(value = userUri, method = {RequestMethod.DELETE})
    public @ResponseBody
    void delete(Integer itemId) {

        userService.delete(itemId);
    }
}
