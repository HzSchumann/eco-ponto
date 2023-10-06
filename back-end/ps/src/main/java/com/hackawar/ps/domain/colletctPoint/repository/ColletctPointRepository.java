package com.hackawar.ps.domain.colletctPoint.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hackawar.ps.domain.colletctPoint.CollectPoint;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository
public class ColletctPointRepository {
    
    private List<CollectPoint> CollectPoints = new ArrayList<CollectPoint>();
}
