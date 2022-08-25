package ru.kata.spring.boot_security.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;
@Service
@ComponentScan("ru.kata.spring.boot_security.demo.dao")
public class UserServiceImpl implements UserService {
    UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDAO) {
        this.userDao = userDAO;
    }
    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }
    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }
    @Override
    public void save(User user) {
        userDao.save(user);
    }
    @Override
    public void update(User user) {
        userDao.update(user);
    }
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }
}
