package com.airbnbserver.domain.entities;

import java.util.Date;
import java.util.UUID;

import com.airbnbserver.domain.dtos.BookingDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "booking")
@Table(name = "booking")
@EqualsAndHashCode(of = "uuid")
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private User guest;

    @ManyToOne
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;

    private Float totalValue;
    private Float assessmentValue = (float) 0;
    private Date startDate;
    private Date endDate;
    private Boolean checkin = false;
    private Boolean cancellation = false;

    public Booking(BookingDTO data, Accommodation accommodation, User guest) {
        this.uuid = UUID.randomUUID();
        this.totalValue = data.totalValue();
        this.startDate = data.startDate();
        this.endDate = data.endDate();
        this.accommodation = accommodation;
        this.guest = guest;
        this.assessmentValue = (float) 0;
        this.checkin = false;
        this.cancellation = false;
    }
}
