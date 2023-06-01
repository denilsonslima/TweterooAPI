package com.project.api.controllers;

import com.project.api.models.UserModels;
import com.project.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/auth")
public class UserControllers {
    @Autowired
    private UserRepository userRepository;
    @PostMapping(value = "/sign-up")
    public ResponseEntity<UserModels> signUp(@RequestBody UserModels user) {
        UserModels savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}
