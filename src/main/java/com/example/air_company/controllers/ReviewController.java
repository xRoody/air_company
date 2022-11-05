package com.example.air_company.controllers;

import com.example.air_company.DTOs.ReviewDTO;
import com.example.air_company.domain.Review;
import com.example.air_company.facades.ReviewDTOFacade;
import com.example.air_company.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@AllArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {
    private ReviewService reviewService;
    private ReviewDTOFacade reviewDTOFacade;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<ReviewDTO>> findById(@PathVariable("id") Long id) {
        return reviewDTOFacade.findById(id).flatMap(x -> Mono.just(ResponseEntity.ok(x))).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(reviewService.delete(id));
    }

    @PostMapping
    public ResponseEntity<Mono<Review>> save(@RequestBody Review review) {
        return ResponseEntity.ok(reviewService.save(review));
    }

    @GetMapping("/user/{id}")
    public Mono<ResponseEntity<Flux<ReviewDTO>>> findAllByUser(@PathVariable("id") Integer id, @RequestParam(required = false, defaultValue = "1") Integer pageNumber) {
        return reviewDTOFacade.findAllByUser(id, Pageable.ofSize(15).withPage(pageNumber))
                .collect(() -> new ArrayList<ReviewDTO>(), ArrayList::add)
                .flatMap(x -> Mono.just(ResponseEntity.ok(Flux.fromIterable(x))))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/company/{id}")
    public Mono<ResponseEntity<Flux<ReviewDTO>>> findAllByCompany(@PathVariable("id") Integer id, @RequestParam(required = false, defaultValue = "1") Integer pageNumber) {
        return reviewDTOFacade.findAllByCompany(id, Pageable.ofSize(15).withPage(pageNumber))
                .collect(() -> new ArrayList<ReviewDTO>(), ArrayList::add)
                .flatMap(x -> Mono.just(ResponseEntity.ok(Flux.fromIterable(x))))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Review>> update(@RequestBody Review review, @PathVariable("id") Long id) {
        return reviewService.update(review, id).flatMap(x -> Mono.just(ResponseEntity.ok(x))).defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
