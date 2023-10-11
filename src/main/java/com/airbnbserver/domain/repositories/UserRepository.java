package com.airbnbserver.domain.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbnbserver.domain.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findUserByUuid(UUID uuid);

    public boolean existsUserByEmail(String email);

    public boolean existsUserByCpf(String cpf);

}
