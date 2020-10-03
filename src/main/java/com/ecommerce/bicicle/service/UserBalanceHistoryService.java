package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.entity.UserBalanceHistory;

import java.util.List;

public interface UserBalanceHistoryService {
    List<UserBalanceHistory> get();

    UserBalanceHistory save(UserBalanceHistory userBalanceHistory);

    void delete(Long userBalanceHistoryId);
}
