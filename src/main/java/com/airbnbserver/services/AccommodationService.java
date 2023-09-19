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

    @Autowired
    private UserService userService;

    public Accommodation createAccommodation(AccommodationDTO accommodationDto) {
        User host = this.userService.getByUuid(accommodationDto.hostUuid());
        Accommodation newAccommodation = new Accommodation(accommodationDto, host);

        return this.repository.save(newAccommodation);
    }

    public List<Accommodation> getAll() {

        return this.repository.findAll();
    }

    public List<Accommodation> getByHost(User host) throws Exception {

        return this.repository.findAccommodationByHost(host)
                .orElseThrow(() -> new Exception("Usuário não possui acomodações cadastradas"));
    }
}
