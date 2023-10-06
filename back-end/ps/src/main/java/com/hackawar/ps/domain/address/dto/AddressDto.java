package com.hackawar.ps.domain.address.dto;

public record AddressDto(
    String street,
    String number,
    String neighborhood,
    String city,
    String state,
    String cep
) {
    
}
