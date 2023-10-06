package com.hackawar.ps.domain.address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    public Address(String street, String number, String neighborhood, String city, String state, String cep) {
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.cep = cep;
    }

    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String cep;
    private String lat;
    private String lng;
    
}
