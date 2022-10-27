package com.example.air_company.services;

import com.example.air_company.DTOs.TicketDTO;
import com.example.air_company.DTOs.UserDTO;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserDTO> getUserById(Integer id);
    Mono<TicketDTO> getTicketById(Long id);
}
