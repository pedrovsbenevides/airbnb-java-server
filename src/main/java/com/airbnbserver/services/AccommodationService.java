package com.airbnbserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbnbserver.domain.dtos.AccommodationDTO;
import com.airbnbserver.domain.entities.Accommodation;
import com.airbnbserver.domain.entities.User;
import com.airbnbserver.domain.repositories.AccommodationRepository;

@Service
public class AccommodationService {

    @Autowired
    private AccommodationRepository repository;

    public Accommodation createAccommodation(AccommodationDTO accommodationDto) {
        Accommodation newAccommodation = new Accommodation(accommodationDto);

        return this.repository.save(newAccommodation);
    }

    public List<Accommodation> getAll() {

        return this.repository.findAll();
    }

    public List<Accommodation> getByHost(User host) {

        return this.repository.findAccommodationByHost(host);
    }
}
