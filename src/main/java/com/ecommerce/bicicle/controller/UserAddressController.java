package com.ecommerce.bicicle.controller;

import com.ecommerce.bicicle.constants.EndpointNames;
import com.ecommerce.bicicle.dto.UserAddressDto;
import com.ecommerce.bicicle.service.UserAddressService;
import com.ecommerce.bicicle.service.UserService;
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

    @RequestMapping(value = userAddressUri, method = {RequestMethod.GET})
    public @ResponseBody
    List<UserAddressDto> get() {

        List<UserAddressDto> itemEntities = userAddressService.get();

        return null;
    }

    @RequestMapping(value = userAddressUri, method = {RequestMethod.PUT})
    public @ResponseBody
    UserAddressDto put(UserAddressDto userAddressDto) {

        //UserAddressDto saveItemUser = userAddressService.save(userAddressDto);

        return null;
    }

    @RequestMapping(value = userAddressUri, method = {RequestMethod.DELETE})
    public @ResponseBody
    void delete(String itemId) {

        userAddressService.delete(itemId);
    }
}
