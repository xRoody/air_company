package com.example.air_company.DTOs;

import com.example.air_company.domain.Company;
import com.example.air_company.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CompanyDTO {
    private Company company;
    private Mono<Double> rating;
    private Flux<Review> reviews;
}
