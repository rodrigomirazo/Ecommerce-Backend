package com.ecommerce.bicicle.service.impl;

import com.ecommerce.bicicle.entity.UserBalanceHistory;
import com.ecommerce.bicicle.repository.UserBalanceHistoryRepository;
import com.ecommerce.bicicle.service.UserBalanceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserBalanceHistoryServiceImpl implements UserBalanceHistoryService {

    @Autowired
    UserBalanceHistoryRepository userBalanceHistoryRepo;

    @Override
    public List<UserBalanceHistory> get() {
        return StreamSupport.stream(
                userBalanceHistoryRepo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public UserBalanceHistory save(UserBalanceHistory userBalanceHistory) {
        return userBalanceHistoryRepo.save(userBalanceHistory);
    }

    @Override
    public void delete(Long userBalanceHistoryId) {
        userBalanceHistoryRepo.deleteById(userBalanceHistoryId);
    }
}
