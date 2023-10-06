package com.hackawar.ps.domain.disposalpeople.dto;

import com.hackawar.ps.domain.address.dto.AddressDto;

public record DisposalPeopleDto(
    String name,
    AddressDto address
) {
    
}
