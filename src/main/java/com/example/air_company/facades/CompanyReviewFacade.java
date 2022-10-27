package com.example.air_company.facades;

import com.example.air_company.DTOs.CompanyDTO;
import reactor.core.publisher.Mono;

public interface CompanyReviewFacade {
    Mono<CompanyDTO> getCompanyDTOById(Integer id);
}
