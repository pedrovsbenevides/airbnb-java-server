package com.airbnbserver.domain.dtos;

public record UserDTO(
        String name,
        String cpf,
        String email,
        String password,
        String phone) {
}
