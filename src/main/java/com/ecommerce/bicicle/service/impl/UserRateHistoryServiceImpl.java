package com.ecommerce.bicicle.service.impl;

import com.ecommerce.bicicle.entity.UserRateHistory;
import com.ecommerce.bicicle.repository.UserRateHistoryRepository;
import com.ecommerce.bicicle.service.UserRateHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserRateHistoryServiceImpl implements UserRateHistoryService {

    @Autowired
    UserRateHistoryRepository userRateHistoryRepository;

    @Override
    public List<UserRateHistory> get() {
        return StreamSupport.stream(
                userRateHistoryRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public UserRateHistory save(UserRateHistory userRateHistory) {
        return userRateHistoryRepository.save(userRateHistory);
    }

    @Override
    public void delete(Long idUserBalanceHistory) {
        userRateHistoryRepository.deleteById(idUserBalanceHistory);
    }
}
