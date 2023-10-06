package com.hackawar.ps.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackawar.ps.domain.address.Address;
import com.hackawar.ps.domain.cnpj.Cnpj;
import com.hackawar.ps.domain.colletctPoint.CollectPoint;
import com.hackawar.ps.domain.colletctPoint.dto.CollectPointDto;
import com.hackawar.ps.domain.colletctPoint.repository.ColletctPointRepository;

@Service
public class ColletctPointService {

    @Autowired
    ColletctPointRepository colletctPointRepository;

    public List<CollectPoint> listAllCollectPoints() {
        return colletctPointRepository.getCollectPoints();
    }

    public void addCollectPoint(CollectPointDto collectPoint) {

        List<CollectPoint> collectPoints = colletctPointRepository.getCollectPoints();

        Cnpj cnpj = new Cnpj(collectPoint.cnpj().number());
        Address address = new Address(collectPoint.address().street(), collectPoint.address().number(),
                collectPoint.address().neighborhood(), collectPoint.address().city(),
                collectPoint.address().state(), collectPoint.address().cep());
        CollectPoint collectPointToAdd = new CollectPoint(collectPoint.name(), cnpj, address);
        
        collectPoints.add(collectPointToAdd);

        colletctPointRepository.setCollectPoints(collectPoints);
    }

}