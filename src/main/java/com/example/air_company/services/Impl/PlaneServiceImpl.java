package com.example.air_company.services.Impl;

import com.example.air_company.domain.Plane;
import com.example.air_company.repositories.PlaneRepo;
import com.example.air_company.services.PlaneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class PlaneServiceImpl implements PlaneService {
    private PlaneRepo planeRepo;

    public Flux<Plane> findAll(){
        return planeRepo.findAll();
    }

    public Mono<Plane> findById(String id){
        return planeRepo.findById(id);
    }

    public Mono<Void> delete(String id){
        return planeRepo.deleteById(id);
    }

    public Mono<Plane> save(Plane plane){
        return planeRepo.save(plane);
    }

    public Mono<Plane> update(Plane plane, String id){
        return planeRepo.findById(id).flatMap(x->{
           if (plane.getModelType()!=null) x.setModelType(plane.getModelType());
           if (plane.getCompanyId()!=null) x.setCompanyId(plane.getCompanyId());
           if (plane.getSitCount()!=null) x.setSitCount(plane.getSitCount());
           return planeRepo.save(x);
        });
    }
}
