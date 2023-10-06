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
import com.hackawar.ps.domain.colletctPoint.CollectPoint;
import com.hackawar.ps.domain.colletctPoint.dto.CollectPointDto;
import com.hackawar.ps.services.ColletctPointService;

@RestController
@RequestMapping("/collectpoints")
public class CollectPointController {

    @Autowired
    ColletctPointService colletctPointService;
    
    @GetMapping()
    public String getAllCollectPoints() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        List<CollectPoint> collectList = colletctPointService.listAllCollectPoints();

        String json = objectMapper.writeValueAsString(collectList);

        return json;
    }

    @PostMapping()
    public void postCollectPoint(@RequestBody CollectPointDto collectPoint) {
        
        colletctPointService.addCollectPoint(collectPoint);
    }
}
