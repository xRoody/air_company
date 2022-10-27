package com.example.air_company.facades;

import com.example.air_company.DTOs.ReviewDTO;
import com.example.air_company.domain.Review;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReviewDTOFacade {
    Mono<ReviewDTO> findById(Long id);
    Flux<ReviewDTO> findAllByUser(Integer id, Pageable pageable);
    Flux<ReviewDTO> findAllByCompany(Integer id, Pageable pageable);
}
