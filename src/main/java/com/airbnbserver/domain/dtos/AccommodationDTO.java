package com.airbnbserver.domain.dtos;

import java.util.UUID;

public record AccommodationDTO(
        UUID hostUuid,
        String cep,
        String address,
        String complement,
        Float daily_fee,
        String description,
        String capacity) {

}
