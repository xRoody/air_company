package com.example.air_company.services;

import com.example.air_company.DTOs.CompanyBasicDTO;
import com.example.air_company.domain.Company;
import org.springframework.data.domain.Sort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CompanyService {
    Flux<CompanyBasicDTO> findAll();

    Mono<Company> findById(Integer id);

    Flux<CompanyBasicDTO> findByName(String name);

    Mono<Void> delete(Integer id);
    Mono<Company> save(Company company);

    Mono<Company> update(Company company, Integer id);
}
