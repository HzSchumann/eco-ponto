package com.hackawar.ps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackawar.ps.domain.disposalpeople.DisposalPeople;
import com.hackawar.ps.domain.disposalpeople.dto.AddPointsDisposalDto;
import com.hackawar.ps.domain.disposalpeople.dto.DisposalPeopleDto;
import com.hackawar.ps.services.DisposalPeopleService;

@RestController
@RequestMapping("/disposal")
public class DisposalPeopleController {

    @Autowired
    DisposalPeopleService disposalPeopleService;

    @GetMapping()
    public String getAllCollectPoints() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        List<DisposalPeople> collectList = disposalPeopleService.listAllDisposalPeoples();

        String json = objectMapper.writeValueAsString(collectList);

        return json;
    }

    @PostMapping("/createDisposal")
    public void addDisposalPeople(@RequestBody DisposalPeopleDto disposalPeopleDto) {
        disposalPeopleService.addDisposalPeople(disposalPeopleDto);
    }

    @PostMapping("/addPoint")
    public void addPoint(@RequestBody AddPointsDisposalDto addPointsDisposalDto) {
        disposalPeopleService.addPoints(addPointsDisposalDto);
    }
}
