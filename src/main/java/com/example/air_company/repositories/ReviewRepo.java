package com.example.air_company.repositories;

import com.example.air_company.domain.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface ReviewRepo extends ReactiveSortingRepository<Review, Long> {

    Flux<Review> findAllByUserId(Integer id, Pageable pageable);
    Flux<Review> findAllByCompanyId(Integer id, Pageable pageable);
}
