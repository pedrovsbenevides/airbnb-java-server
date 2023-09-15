package com.airbnbserver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airbnbserver.domain.dtos.UserDTO;
import com.airbnbserver.domain.entities.User;
import com.airbnbserver.services.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(this.service.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDTO userDto) {
        User newUser = this.service.createUser(userDto);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

}
