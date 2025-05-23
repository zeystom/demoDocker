package com.example.demo.repositories;

import com.example.demo.entity.User;
import com.example.demo.entity.payload.UserPayload;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    
}
