package com.example.air_company;

import com.example.air_company.services.Impl.ReviewServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collector;
import java.util.stream.Collectors;

@SpringBootApplication
public class AirCompanyApplication {

    public static void main(String[] args) {
        ApplicationContext context=SpringApplication.run(AirCompanyApplication.class, args);
    }

}
