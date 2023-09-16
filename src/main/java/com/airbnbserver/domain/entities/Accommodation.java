package com.airbnbserver.domain.entities;

import java.util.UUID;

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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "accommodation")
@Table(name = "accommodation")
@EqualsAndHashCode(of = "uuid")
@NoArgsConstructor
@Getter
@Setter
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User host;

    private String cep;
    private String address;
    private String complemet;
    private String daily_fee;
    private String description;
    private String capacity;
}
