package com.hackawar.ps.domain.disposalpeople;

import com.hackawar.ps.domain.address.Address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisposalPeople {

    public DisposalPeople(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    
    private String name;
    private Address address;
    private int points;
    
}
