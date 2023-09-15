package com.airbnbserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbnbserver.domain.dtos.UserDTO;
import com.airbnbserver.domain.entities.User;
import com.airbnbserver.domain.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User createUser(UserDTO userDto) {
        User newUser = new User(userDto);

        return this.repository.save(newUser);
    }
}
