package com.airbnbserver.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbnbserver.domain.entities.Accommodation;
import com.airbnbserver.domain.entities.User;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

    public Optional<List<Accommodation>> findAccommodationByHost(User host);
}
