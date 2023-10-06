package com.hackawar.ps.domain.colletctPoint;

import com.hackawar.ps.domain.address.Address;
import com.hackawar.ps.domain.cnpj.Cnpj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CollectPoint {

    public CollectPoint(String name, Cnpj cnpj, Address address) {
        this.name = name;
        this.cnpj = cnpj;
        this.address = address;
    }

    private String name;
    private Cnpj cnpj;
    private Address address;

}
