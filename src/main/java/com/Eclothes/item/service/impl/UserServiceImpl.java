package com.Eclothes.item.service.impl;

import com.Eclothes.item.entity.User;
import com.Eclothes.item.entity.UserBalanceHistory;
import com.Eclothes.item.repository.UserRepository;
import com.Eclothes.item.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> get() {
        return StreamSupport.stream(
                userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }
}
