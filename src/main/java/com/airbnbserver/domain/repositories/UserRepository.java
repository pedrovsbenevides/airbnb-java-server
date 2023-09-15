package com.airbnbserver.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbnbserver.domain.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
