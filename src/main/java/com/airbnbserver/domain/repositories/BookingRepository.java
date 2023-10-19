package com.airbnbserver.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbnbserver.domain.entities.Booking;
import com.airbnbserver.domain.entities.User;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    public Optional<List<Booking>> findBookingByGuest(User guest);
}
