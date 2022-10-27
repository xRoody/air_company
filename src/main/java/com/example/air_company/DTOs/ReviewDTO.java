package com.example.air_company.DTOs;

import com.example.air_company.domain.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReviewDTO {
    private Long id;
    private Mono<Company> company;
    private Mono<UserDTO> userDTO;
    private String info;
    private Double reviewRating;
    private Double setRating;
    private Mono<TicketDTO> ticketDTO;
}
