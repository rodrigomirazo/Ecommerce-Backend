package com.Eclothes.item.service;

import com.Eclothes.item.entity.User;
import java.util.List;

public interface UserService {
    List<User> get();

    User save(User user);

    void delete(Long userId);
}
