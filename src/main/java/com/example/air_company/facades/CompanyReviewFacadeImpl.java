package com.example.air_company.facades;

import com.example.air_company.DTOs.CompanyDTO;
import com.example.air_company.domain.Review;
import com.example.air_company.repositories.ReviewRepo;
import com.example.air_company.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CompanyReviewFacadeImpl implements CompanyReviewFacade{
    private CompanyService companyService;
    private ReviewRepo reviewRepo;

    public Mono<CompanyDTO> getCompanyDTOById(Integer id) {
        return companyService.findById(id).map(x -> {
            Flux<Review> reviewFlux = reviewRepo.findAllByCompanyId(id, Pageable.ofSize(10).first());
            return CompanyDTO.builder()
                    .company(x)
                    .rating(reviewFlux.collect(Collectors.averagingDouble(Review::getSetRating)))
                    .reviews(reviewFlux)
                    .build();
        });
    }
}
