package com.hackawar.ps.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackawar.ps.domain.address.Address;
import com.hackawar.ps.domain.disposalpeople.DisposalPeople;
import com.hackawar.ps.domain.disposalpeople.dto.AddPointsDisposalDto;
import com.hackawar.ps.domain.disposalpeople.dto.DisposalPeopleDto;
import com.hackawar.ps.domain.disposalpeople.repository.DisposalPeopleRepository;

@Service
public class DisposalPeopleService {

    @Autowired
    DisposalPeopleRepository disposalPeopleRepository;

    public List<DisposalPeople> listAllDisposalPeoples() {
        return disposalPeopleRepository.getDisposalPeoples();
    }

    public void addDisposalPeople(DisposalPeopleDto disposalPeopleDto) {
        List<DisposalPeople> disposalPeoples = disposalPeopleRepository.getDisposalPeoples();

        Address address = new Address(disposalPeopleDto.address().street(), disposalPeopleDto.address().number(),
                disposalPeopleDto.address().neighborhood(), disposalPeopleDto.address().city(),
                disposalPeopleDto.address().state(), disposalPeopleDto.address().cep());

        DisposalPeople disposalPeople = new DisposalPeople(disposalPeopleDto.name(), address);

        disposalPeoples.add(0, disposalPeople);

        disposalPeopleRepository.setDisposalPeoples(disposalPeoples);
    }

    public void addPoints(AddPointsDisposalDto addPointsDisposalDto) {

        disposalPeopleRepository.getDisposalPeoples().stream()
                .filter(peopleToFind -> peopleToFind.getName().equals(addPointsDisposalDto.name()))
                .forEach(peopleFound -> peopleFound.setPoints(peopleFound.getPoints() + addPointsDisposalDto.points()));

    }
}
