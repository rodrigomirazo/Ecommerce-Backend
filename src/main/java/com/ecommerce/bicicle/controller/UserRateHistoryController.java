package com.ecommerce.bicicle.controller;

import com.ecommerce.bicicle.constants.EndpointNames;
import com.ecommerce.bicicle.dto.UserRateHistoryDto;
import com.ecommerce.bicicle.service.UserRateHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = EndpointNames.URI)
public class UserRateHistoryController {

    private static final String userRateHistoryUri = EndpointNames.USER_RATE_HISTORY_CONTROLLER;

    @Autowired
    private UserRateHistoryService userRateHistoryService;

    @RequestMapping(value = userRateHistoryUri, method = {RequestMethod.GET})
    public @ResponseBody
    List<UserRateHistoryDto> get() {
        return null;
    }

    @RequestMapping(value = userRateHistoryUri, method = {RequestMethod.PUT})
    public @ResponseBody
    UserRateHistoryDto put(UserRateHistoryDto userRateHistoryDto) {

        return null;
    }

    @RequestMapping(value = userRateHistoryUri, method = {RequestMethod.DELETE})
    public @ResponseBody
    void delete(Long itemId) {
    }
}
