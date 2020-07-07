package com.Eclothes.item.controller;

import com.Eclothes.item.constants.EndpointNames;
import com.Eclothes.item.dto.UserAddressDto;
import com.Eclothes.item.entity.Item;
import com.Eclothes.item.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = EndpointNames.URI)
public class UserAddressController {

    private static final String userAddressUri = EndpointNames.USER_ADDRESS_CONTROLLER;

    @Autowired
    private UserService userService;

    @RequestMapping(value = userAddressUri, method = {RequestMethod.GET})
    public @ResponseBody
    List<UserAddressDto> get() {

        //List<UserAddressDto> itemEntities = userService.get();

        return null;
    }

    @RequestMapping(value = userAddressUri, method = {RequestMethod.PUT})
    public @ResponseBody
    UserAddressDto put(UserAddressDto userAddressDto) {

        //UserAddressDto saveItemUser = userService.save(userAddressDto);

        return null;
    }

    @RequestMapping(value = userAddressUri, method = {RequestMethod.DELETE})
    public @ResponseBody
    void delete(Long itemId) {

        userService.delete(itemId);
    }
}
