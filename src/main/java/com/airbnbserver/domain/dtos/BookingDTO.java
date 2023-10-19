package com.airbnbserver.domain.dtos;

import java.util.Date;
import java.util.UUID;

public record BookingDTO(
    UUID guestUuid,
    Float totalValue,
    Date startDate,
    Date endDate,
    Integer guestsNumber
) {
    
}
