package com.example.air_company.controllers;

import com.example.air_company.DTOs.CompanyBasicDTO;
import com.example.air_company.DTOs.CompanyDTO;
import com.example.air_company.domain.Company;
import com.example.air_company.facades.CompanyReviewFacade;
import com.example.air_company.facades.CompanyReviewFacadeImpl;
import com.example.air_company.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
@AllArgsConstructor
@RequestMapping("/company")
public class CompanyController {
    private CompanyService companyService;
    private CompanyReviewFacade companyReviewFacade;

    @GetMapping
    public ResponseEntity<Flux<CompanyBasicDTO>> findAll(@RequestParam(value = "name", required = false) String name){
        if (name==null) return ResponseEntity.ok(companyService.findAll());
        return ResponseEntity.ok(companyService.findByName(name));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<CompanyDTO>> findById(@PathVariable("id") Integer id){
       return companyReviewFacade.getCompanyDTOById(id)
               .map(ResponseEntity::ok)
               .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> delete(@PathVariable("id") Integer id){
        return ResponseEntity.ok(companyService.delete(id));
    }

    @PostMapping
    public ResponseEntity<Mono<Company>> save(@RequestBody Company company){
        return ResponseEntity.ok(companyService.save(company));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Company>> update(@RequestBody Company company, @PathVariable("id") Integer id){
        return companyService.update(company, id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
