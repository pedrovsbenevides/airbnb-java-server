package com.airbnbserver.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbnbserver.domain.dtos.BookingDTO;
import com.airbnbserver.domain.entities.Accommodation;
import com.airbnbserver.domain.entities.Booking;
import com.airbnbserver.domain.entities.User;
import com.airbnbserver.domain.repositories.BookingRepository;
import com.airbnbserver.exceptions.BusinessException;

@Service
public class BookingService {
    @Autowired
    private BookingRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private AccommodationService accommodationService;

    public Booking create(BookingDTO data, UUID accommodationUuid) throws Exception {
        User guest = userService.getByUuid(data.guestUuid());
        Accommodation accommodation = accommodationService.getByUuid(accommodationUuid);

        this.validateGuestsNumber(Integer.parseInt(accommodation.getCapacity()), data.guestsNumber());
        Booking booking = new Booking(data, accommodation, guest);

        try {

            return repository.save(booking);
        } catch (Exception error) {
            throw error;
        }
    }

    private void validateGuestsNumber(Integer accommodationCapacity, Integer guestsNumber) {

        if (guestsNumber > accommodationCapacity) {
            throw new BusinessException("Número de hóspedes ultrapassa a capacidade da acomodação");
        }
    }
}
