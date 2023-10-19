package com.airbnbserver.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airbnbserver.domain.dtos.BookingDTO;
import com.airbnbserver.domain.entities.Booking;
import com.airbnbserver.services.BookingService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService service;

    @PostMapping("accommodations/{accommodationUuid}")
    public ResponseEntity<Booking> create(@PathVariable("accommodationUuid") UUID accommodationUuid,
            @RequestBody BookingDTO data) throws Exception {
        Booking newBooking = this.service.create(data, accommodationUuid);

        return new ResponseEntity<>(newBooking, HttpStatus.OK);
    }

}
