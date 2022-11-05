package com.example.air_company.services.Impl;

import com.example.air_company.DTOs.CompanyBasicDTO;
import com.example.air_company.domain.Company;
import com.example.air_company.facades.CompanyFacade;
import com.example.air_company.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private CompanyFacade companyFacade;

    public Flux<CompanyBasicDTO> findAll() {
        return companyFacade.findAllBasicDto();
    }

    public Mono<Company> findById(Integer id) {
        return companyFacade.findById(id);
    }

    public Flux<CompanyBasicDTO> findByName(String name) {
        return companyFacade.findAllBasicDtoWhereNameLike(name);
    }

    public Mono<Void> delete(Integer id) {
        return companyFacade.deleteById(id);
    }

    public Mono<Company> save(Company company) {
        return companyFacade.save(company);
    }

    public Mono<Company> update(Company company, Integer id) {
        return companyFacade.update(company, id);
    }
}
