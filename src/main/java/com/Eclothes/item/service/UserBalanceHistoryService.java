package com.Eclothes.item.service;

import com.Eclothes.item.entity.UserBalanceHistory;

import java.util.List;

public interface UserBalanceHistoryService {
    List<UserBalanceHistory> get();

    UserBalanceHistory save(UserBalanceHistory userBalanceHistory);

    void delete(Long userBalanceHistoryId);
}
