package com.example.SpringBootRedis_demo.repository;

import com.example.SpringBootRedis_demo.model.User;

import java.util.List;

public interface UserDao {
    boolean saveUser(User user);

    List<User> getUsers();

    User getUser(Long id);

    boolean deleteUserById(Long id);

    boolean updateUser(Long id, User user);
}
