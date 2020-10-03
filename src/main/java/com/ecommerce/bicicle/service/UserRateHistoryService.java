package com.ecommerce.bicicle.service;

import com.ecommerce.bicicle.entity.UserRateHistory;

import java.util.List;

public interface UserRateHistoryService {

    List<UserRateHistory> get();

    UserRateHistory save(UserRateHistory userRateHistory);

    void delete(Long userRateHistoryId);
}
