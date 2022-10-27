package com.example.air_company.repositories;

import com.example.air_company.domain.Company;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface CompanyRepo extends ReactiveSortingRepository<Company, Integer> {
    Flux<Company> findAllByTitleLikeOrderByTitle(String title);
}
