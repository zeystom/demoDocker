package com.example.demo.services.impl;

import com.example.demo.entity.User;
import com.example.demo.entity.payload.UserPayload;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Transactional
    @Override
    public User createUser(UserPayload payload) {
        User user = mapper.toEntity(payload);
        return repository.save(user);
    }

    @Override
    public Optional<User> findById(int id) {
        if (id == -1)
            return Optional.empty();
        return repository.findById(id);
    }

    @Override
    public Iterable<User> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        repository.deleteById(id);
    }

    @Transactional
    @Override
    public void updateUser(int id, UserPayload payload) {
    repository.findById(id).ifPresent(user -> {
        mapper.updateEntity(user, payload);
    });
    }
}
