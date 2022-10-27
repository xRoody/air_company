package com.example.air_company.controllers;

import com.example.air_company.domain.Plane;
import com.example.air_company.services.PlaneService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/plane")
public class PlaneController {
    private PlaneService planeService;

    @GetMapping
    public ResponseEntity<Flux<Plane>> findAll(){
        return ResponseEntity.ok(planeService.findAll());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Plane>> findById(@PathVariable("id") String id){
        return planeService.findById(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> delete(@PathVariable("id") String id){
        return ResponseEntity.ok(planeService.delete(id));
    }

    @PostMapping
    public ResponseEntity<Mono<Plane>> save(@RequestBody Plane plane){
        return ResponseEntity.ok(planeService.save(plane));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<Plane>> update(@RequestBody Plane plane, @PathVariable("id") String id){
        return ResponseEntity.ok(planeService.update(plane, id));
    }
}
