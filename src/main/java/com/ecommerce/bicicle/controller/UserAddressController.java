package com.ecommerce.bicicle.controller;

import com.ecommerce.bicicle.constants.EndpointNames;
import com.ecommerce.bicicle.dto.UserAddressDto;
import com.ecommerce.bicicle.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = EndpointNames.URI)
public class UserAddressController {

    private static final String userAddressUri = EndpointNames.USER_ADDRESS_CONTROLLER;

    @Autowired
    private UserAddressService userAddressService;

    @RequestMapping(value = userAddressUri + "/{userName}", method = {RequestMethod.GET})
    public @ResponseBody
    UserAddressDto getByUserAccount(@PathVariable(value = "userName")  String userName) {

        List<UserAddressDto> itemEntities = userAddressService.getByUserName(userName);

        return itemEntities.get(0);
    }

    @RequestMapping(value = userAddressUri, method = {RequestMethod.POST})
    public @ResponseBody
    UserAddressDto post(@RequestBody UserAddressDto userAddressDto) {

        UserAddressDto saveItemUser = userAddressService.save(userAddressDto);

        return saveItemUser;
    }

    @RequestMapping(value = userAddressUri, method = {RequestMethod.DELETE})
    public @ResponseBody
    void delete(String itemId) {

        userAddressService.delete(itemId);
    }
}
