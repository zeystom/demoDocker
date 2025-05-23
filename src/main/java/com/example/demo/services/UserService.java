package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.entity.payload.UserPayload;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(UserPayload user);
    Optional<User> findById(int id);
    Iterable<User> findAll();
    void deleteUser(int id);
    void updateUser(int id, UserPayload name);
}
