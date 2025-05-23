package com.example.demo.controllers;

import com.example.demo.entity.User;
import com.example.demo.entity.payload.UserPayload;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Tag(name = "User Management", description = "APIs for managing users")
public class UserController {
    private final UserService userRepository;

    @Operation(
            summary = "Get all users",
            description = "Retrieves a list of all users in the system",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of users"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @GetMapping("/getAll")
    public ResponseEntity<Iterable<User>> getUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @Operation(
            summary = "Get user by ID",
            description = "Retrieves a single user by their unique identifier",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved user"),
                    @ApiResponse(responseCode = "404", description = "User not found")
            },
            parameters = {
                    @Parameter(name = "id", description = "ID of the user to retrieve", required = true)
            })
    @GetMapping("/getOne/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        return userRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Create a new user",
            description = "Creates a new user with the provided details",
            responses = {
                    @ApiResponse(responseCode = "201", description = "User created successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid input"),
                    @ApiResponse(responseCode = "409", description = "User already exists")
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "User payload to create",
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = UserPayload.class)
                    )
            )
    )
    @PostMapping("/createUser")
    public ResponseEntity<User> userCreate(@RequestBody UserPayload user) {
        User saved = userRepository.createUser(user);
        return ResponseEntity.status(201).body(saved);
    }


    @Operation(
            summary = "Delete a user",
            description = "Deletes a user by their ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "User deleted successfully"),
                    @ApiResponse(responseCode = "404", description = "User not found")
            },
            parameters = {
                    @Parameter(name = "id", description = "ID of the user to delete", required = true)
            })
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> userDelete(@RequestParam(required = false) Integer id) {
        if (id == null || userRepository.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update user details",
            description = "Updates the details of an existing user",
            responses = {
                    @ApiResponse(responseCode = "204", description = "User updated successfully"),
                    @ApiResponse(responseCode = "404", description = "User not found"),
                    @ApiResponse(responseCode = "400", description = "Invalid input")
            },
            parameters = {
                    @Parameter(name = "id", description = "ID of the user to update", required = true)
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Updated user details",
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = UserPayload.class)
                    )
            ))
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable int id, @RequestBody UserPayload user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        userRepository.updateUser(id, user);
        return ResponseEntity.noContent().build();
    }
}