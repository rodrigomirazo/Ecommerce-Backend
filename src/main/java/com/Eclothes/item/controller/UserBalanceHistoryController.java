package com.Eclothes.item.controller;

import com.Eclothes.item.constants.EndpointNames;
import com.Eclothes.item.dto.UserBalanceHistoryDto;
import com.Eclothes.item.entity.Item;
import com.Eclothes.item.entity.UserBalanceHistory;
import com.Eclothes.item.service.UserBalanceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = EndpointNames.URI)
public class UserBalanceHistoryController {

    private static final String userBalanceHistoryUri = EndpointNames.USER_BALANCE_HISTORY_CONTROLLER;
    
    @Autowired
    private UserBalanceHistoryService userBalanceHistory;

    @RequestMapping(value = userBalanceHistoryUri, method = {RequestMethod.GET})
    public @ResponseBody
    List<UserBalanceHistoryDto> get() {

        //List<UserBalanceHistoryDto> itemEntities = userBalanceHistory.get();

        return null;
    }

    @RequestMapping(value = userBalanceHistoryUri, method = {RequestMethod.PUT})
    public @ResponseBody
    UserBalanceHistoryDto put(UserBalanceHistoryDto userBalanceHistoryDto) {

        //UserBalanceHistoryDto saveItemUser = userBalanceHistory.save(userBalanceHistoryDto);

        return null;
    }

    @RequestMapping(value = userBalanceHistoryUri, method = {RequestMethod.DELETE})
    public @ResponseBody
    void delete(Long itemId) {

        //userBalanceHistory.delete(itemId);
    }
}
