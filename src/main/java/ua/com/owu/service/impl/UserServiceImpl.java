package ua.com.owu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.com.owu.dao.UserDao;
import ua.com.owu.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserDao dao;

    @Override
    public void save(User user) {
        dao.save(user);

    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User findByUserName(String name) {
        return dao.findByUserName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUserName(username);
    }
}
