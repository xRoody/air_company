package com.example.air_company.facades;

import com.example.air_company.DTOs.CompanyBasicDTO;
import com.example.air_company.domain.Company;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CompanyFacade {
    Flux<CompanyBasicDTO> findAllBasicDto();
    Flux<CompanyBasicDTO> findAllBasicDtoWhereNameLike(@Param("title") String title);
    Mono<Company> findById(Integer id);
    Mono<Void> deleteById(Integer id);
    Mono<Company> save(Company company);

    Mono<Company> update(Company company, Integer id);
}
