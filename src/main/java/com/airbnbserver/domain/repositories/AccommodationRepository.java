package com.airbnbserver.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbnbserver.domain.entities.Accommodation;
import com.airbnbserver.domain.entities.User;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

    public List<Accommodation> findAccommodationByHost(User host);
}
