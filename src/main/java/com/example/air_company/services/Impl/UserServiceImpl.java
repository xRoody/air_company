package com.example.air_company.services.Impl;

import com.example.air_company.DTOs.TicketDTO;
import com.example.air_company.DTOs.UserDTO;
import com.example.air_company.services.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Mono<UserDTO> getUserById(Integer id) {
        return null;
    }

    @Override
    public Mono<TicketDTO> getTicketById(Long id) {
        return null;
    }
}
