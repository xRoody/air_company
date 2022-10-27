package com.example.air_company.repositories;

import com.example.air_company.domain.Plane;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PlaneRepo extends ReactiveCrudRepository<Plane, String> {
}
