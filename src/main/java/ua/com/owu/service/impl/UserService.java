package ua.com.owu.service.impl;

import org.springframework.data.repository.query.Param;
import ua.com.owu.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);
    List<User> findAll();
    User findByUserName( String name);
}
