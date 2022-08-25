package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    User getUser(Long id);
    void save(User user);
    void update(User user);
    void delete(Long id);
}
