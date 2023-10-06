package com.hackawar.ps.domain.disposalpeople.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hackawar.ps.domain.disposalpeople.DisposalPeople;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository
public class DisposalPeopleRepository {
       List<DisposalPeople> disposalPeoples = new ArrayList<>();
}
