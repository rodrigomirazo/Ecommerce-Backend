package com.Eclothes.item.controller;

import com.Eclothes.item.config.GlobalConstant;
import com.Eclothes.item.constants.EndpointNames;
import com.Eclothes.item.dto.UserRateHistoryDto;
import com.Eclothes.item.entity.Item;
import com.Eclothes.item.entity.UserRateHistory;
import com.Eclothes.item.service.ItemService;
import com.Eclothes.item.service.UserRateHistoryService;
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
