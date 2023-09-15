package com.airbnbserver.domain.entities;

import java.util.UUID;

import com.airbnbserver.domain.dtos.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "users")
@Table(name = "users")
@EqualsAndHashCode(of = "uuid")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private UUID uuid;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    private String name;
    private String password;
    private String phone;

    public User(UserDTO userDTO) {
        this.name = userDTO.name();
        this.cpf = userDTO.cpf();
        this.email = userDTO.email();
        this.password = userDTO.password();
        this.phone = userDTO.phone();
        this.uuid = UUID.randomUUID();
    }

}
