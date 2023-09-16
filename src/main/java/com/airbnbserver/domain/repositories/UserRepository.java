package com.airbnbserver.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbnbserver.domain.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findUserByUuid(UUID userUuid);

}
