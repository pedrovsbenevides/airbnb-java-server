package com.airbnbserver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airbnbserver.domain.dtos.AccommodationDTO;
import com.airbnbserver.domain.entities.Accommodation;
import com.airbnbserver.services.AccommodationService;

@RestController
@RequestMapping("/accommodations")
public class AccommodationController {

    @Autowired
    private AccommodationService service;

    @GetMapping
    public ResponseEntity<List<Accommodation>> getAll() {

        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Accommodation> create(@RequestBody AccommodationDTO data) {

        return new ResponseEntity<>(this.service.createAccommodation(data), HttpStatus.OK);
    }
}
