package com.example.air_company.repositories;

import com.example.air_company.DTOs.CompanyBasicDTO;
import com.example.air_company.domain.Company;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface CompanyRepo extends ReactiveSortingRepository<Company, Integer> {
}
