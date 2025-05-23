package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.example.demo.entity.payload.UserPayload;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserPayload payload){
        return new User(null, payload.name(), payload.age(),payload.email());
    }

    public void updateEntity(User user, UserPayload payload){
        user.setName(payload.name());
        user.setEmail(payload.email());
        user.setAge(payload.age());
    }
}
