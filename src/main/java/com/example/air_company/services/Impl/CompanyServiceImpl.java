package com.example.air_company.services.Impl;

import com.example.air_company.domain.Company;
import com.example.air_company.repositories.CompanyRepo;
import com.example.air_company.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService{
    private CompanyRepo companyRepo;

    public Flux<Company> findAll(){
        return companyRepo.findAll(Sort.unsorted());
    }

    public Mono<Company> findById(Integer id){
        return companyRepo.findById(id);
    }

    public Flux<Company> findByName(String name){
        return companyRepo.findAllByTitleLikeOrderByTitle(name);
    }

    public Mono<Void> delete(Integer id){
        return companyRepo.deleteById(id);
    }

    public Mono<Company> save(Company company){
        return companyRepo.save(company);
    }

    public Mono<Company> update(Company company, Integer id){
        return companyRepo.findById(id).flatMap(x->{
            if (company.getTitle()!=null) x.setTitle(company.getTitle());
            if (company.getDescr()!=null) x.setDescr(company.getDescr());
            if (company.getPrev()!=null) x.setPrev(company.getPrev());
            return companyRepo.save(x);
        });
    }
}
