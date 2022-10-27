package com.example.air_company.services;

import com.example.air_company.domain.Plane;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlaneService {
    Flux<Plane> findAll();

    Mono<Plane> findById(String id);

    Mono<Void> delete(String id);

    Mono<Plane> save(Plane plane);

    Mono<Plane> update(Plane plane, String id);
}
