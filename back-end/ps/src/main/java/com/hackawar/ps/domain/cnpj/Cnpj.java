package com.hackawar.ps.domain.cnpj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cnpj {

    public Cnpj(String number) {
        this.number = number;
    }

    private String number;

}
