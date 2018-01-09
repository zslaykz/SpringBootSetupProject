package ua.com.owu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.owu.dao.UserDao;
import ua.com.owu.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    @Override
    public void save(User user) {
        dao.save(user);

    }

    @Override
    public List<User> findAll() {
        return dao.findAll;
    }
}
