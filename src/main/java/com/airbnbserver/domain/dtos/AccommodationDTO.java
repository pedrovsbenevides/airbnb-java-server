package com.airbnbserver.domain.dtos;

import com.airbnbserver.domain.entities.User;

public record AccommodationDTO(
        User host,
        String cep,
        String address,
        String complemet,
        String daily_fee,
        String description,
        String capacity) {

}
