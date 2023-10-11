package com.airbnbserver.services;

import java.util.List;
import java.util.UUID;

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
        return this.repository.findAll();
    }

    public User createUser(UserDTO userData) throws Exception {
        User newUser = new User(userData);

        this.validateCPF(userData);
        this.validateEmail(userData);

        try {

            return this.repository.save(newUser);
        } catch (Exception error) {
            throw error;
        }

    }

    public User createUser(User newUser) throws Exception {

        this.validateCPF(newUser);
        this.validateEmail(newUser);

        try {

            return this.repository.save(newUser);
        } catch (Exception error) {
            throw error;
        }
    }

    public User getByUuid(UUID userUuid) throws Exception {

        return this.repository.findUserByUuid(userUuid).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    private void validateEmail(UserDTO userData) throws Exception {
        if (!this.repository.existsUserByEmail(userData.email())) {
            throw new Exception("Ja existe um usuário registrado com essas informações");
        }
    }

    private void validateCPF(UserDTO userData) throws Exception {
        if (!this.repository.existsUserByCpf(userData.cpf())) {
            throw new Exception("Ja existe um usuário registrado com essas informações");
        }
    }

    private void validateEmail(User user) throws Exception {
        if (!this.repository.existsUserByEmail(user.getEmail())) {
            throw new Exception("Já existe um usuário registrado com essas informações");
        }
    }

    private void validateCPF(User user) throws Exception {
        if (!this.repository.existsUserByCpf(user.getCpf())) {
            throw new Exception("Já existe um usuário registrado com essas informações");
        }
    }
}
