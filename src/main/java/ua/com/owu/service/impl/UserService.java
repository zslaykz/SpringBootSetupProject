package ua.com.owu.service.impl;

import ua.com.owu.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);
    List<User> findAll();
}
