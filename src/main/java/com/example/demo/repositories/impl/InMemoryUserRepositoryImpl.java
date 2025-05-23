package com.example.demo.repositories.impl;

import com.example.demo.entity.User;
import com.example.demo.entity.payload.UserPayload;
import com.example.demo.repositories.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.*;
@Primary
@Repository
public class InMemoryUserRepositoryImpl  {

//    private final List<User> users = Collections.synchronizedList(new LinkedList<>());
//
//    public InMemoryUserRepositoryImpl() {
//        for (int i = 0; i < 5; i++) {
//            users.add(User.builder().id(i).email("bobik" + i + "@gmail.com").name("BOoooob" + i).age(20 + i).build());
//        }
//    }
//
//    @Override
//    public User createUser(User user) {
//        user.setId(users.stream().max(Comparator.comparing(User::getId)).map(User::getId).orElse(0) + 1);
//        users.add(user);
//        return user;
//    }
//
//    @Override
//    public Optional<User> findById(int id) {
//        return users.stream().filter(user -> user.getId() == id).findFirst();
//    }
//
//    @Override
//    public List<User> findAll() {
//        return Collections.unmodifiableList(users);
//    }
//
//    @Override
//    public void deleteUser(int id) {
//        users.removeIf(user -> user.getId() == id);
//    }
//
//    @Override
//    public void updateNameById(int id, String name) {
//        Optional<User> user = users.stream().filter(userik -> userik.getId() == id).findFirst();
//        user.ifPresent(value -> value.setName(name));
//    }

}
