package com.hackawar.ps.domain.colletctPoint.dto;

import com.hackawar.ps.domain.address.dto.AddressDto;
import com.hackawar.ps.domain.cnpj.dto.CnpjDto;

public record CollectPointDto(
    String name,
    AddressDto address,
    CnpjDto cnpj
) {

}
