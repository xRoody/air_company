package com.example.air_company.facades;

import com.example.air_company.DTOs.ReviewDTO;
import com.example.air_company.services.CompanyService;
import com.example.air_company.services.ReviewService;
import com.example.air_company.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class ReviewDTOFacadeImpl implements ReviewDTOFacade {
    private ReviewService reviewService;
    private CompanyService companyService;
    private UserService userService;

    @Override
    public Mono<ReviewDTO> findById(Long id) {
        return reviewService.findById(id).map(x -> ReviewDTO.builder()
                .id(x.getId())
                .company(companyService.findById(x.getCompanyId()))
                .info(x.getInfo())
                .reviewRating(x.getReviewRating())
                .setRating(x.getSetRating())
                .userDTO(userService.getUserById(x.getUserId()))
                .ticketDTO(userService.getTicketById(x.getTicketId()))
                .build());
    }

    @Override
    public Flux<ReviewDTO> findAllByUser(Integer id, Pageable pageable) {
        return reviewService.findAllByUser(id, pageable)
                .map(x -> ReviewDTO.builder()
                        .id(x.getId())
                        .company(companyService.findById(x.getCompanyId()))
                        .info(x.getInfo())
                        .reviewRating(x.getReviewRating())
                        .setRating(x.getSetRating())
                        .userDTO(userService.getUserById(x.getUserId()))
                        .ticketDTO(userService.getTicketById(x.getTicketId()))
                        .build());
    }

    @Override
    public Flux<ReviewDTO> findAllByCompany(Integer id, Pageable pageable) {
        return reviewService.findAllByCompany(id, pageable)
                .map(x -> ReviewDTO.builder()
                        .id(x.getId())
                        .company(companyService.findById(x.getCompanyId()))
                        .info(x.getInfo())
                        .reviewRating(x.getReviewRating())
                        .setRating(x.getSetRating())
                        .userDTO(userService.getUserById(x.getUserId()))
                        .ticketDTO(userService.getTicketById(x.getTicketId()))
                        .build());
    }
}
