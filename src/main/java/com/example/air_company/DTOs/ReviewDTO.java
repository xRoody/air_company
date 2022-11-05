package com.example.air_company.DTOs;

import com.example.air_company.domain.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReviewDTO {
    private Long id;
    private Mono<Company> company;
    private Integer userId;
    private String info;
    private Double reviewRating;
    private Double setRating;
    private LocalDateTime dateTime;
    private Long ticketId;
}
