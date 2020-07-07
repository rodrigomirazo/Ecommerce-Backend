package com.Eclothes.item.service;

import com.Eclothes.item.entity.UserBalanceHistory;
import com.Eclothes.item.entity.UserRateHistory;

import java.util.List;

public interface UserRateHistoryService {

    List<UserRateHistory> get();

    UserRateHistory save(UserRateHistory userRateHistory);

    void delete(Long userRateHistoryId);
}
