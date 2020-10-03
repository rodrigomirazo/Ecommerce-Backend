package com.ecommerce.bicicle.controller;

import com.ecommerce.bicicle.constants.EndpointNames;
import com.ecommerce.bicicle.dto.UserDto;
import com.ecommerce.bicicle.service.UserService;
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

    @RequestMapping(value = userUri+"/{userId}", method = {RequestMethod.GET})
    public @ResponseBody
    UserDto get(@PathVariable("userId") Integer userId) {

        UserDto itemEntities = userService.get(userId);

        return itemEntities;
    }

    @RequestMapping(value = userUri, method = {RequestMethod.PUT})
    public @ResponseBody
    UserDto put(@RequestBody UserDto userDto) {

        UserDto savedItemUser = userService.save(userDto);

        return savedItemUser;
    }

    @RequestMapping(value = userUri, method = {RequestMethod.DELETE})
    public @ResponseBody
    void delete(@RequestParam Integer itemId) {

        userService.delete(itemId);
    }
}
