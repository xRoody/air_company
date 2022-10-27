package com.example.air_company.services;

import com.example.air_company.domain.Review;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReviewService {
    Flux<Review> findAll();

    Mono<Review> findById(Long id);

    Mono<Void> delete(Long id);

    Mono<Review> save(Review review);

    Flux<Review> findAllByUser(Integer id, Pageable pageable);

    Flux<Review> findAllByCompany(Integer id, Pageable pageable);

    Mono<Review> update(Review review, Long id);
}
