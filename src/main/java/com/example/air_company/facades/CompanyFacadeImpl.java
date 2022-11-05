package com.example.air_company.facades;

import com.example.air_company.DTOs.CompanyBasicDTO;
import com.example.air_company.domain.Company;
import com.example.air_company.repositories.BasicCompanyDTORepo;
import com.example.air_company.repositories.CompanyRepo;
import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CompanyFacadeImpl implements CompanyFacade{
    private CompanyRepo companyRepo;
    private BasicCompanyDTORepo basicCompanyDTORepo;
    private AsyncLoadingCache<Integer, Company> companyId;

    @Autowired
    public CompanyFacadeImpl(CompanyRepo  companyRepo, BasicCompanyDTORepo basicCompanyDTORepo) {
        this.companyRepo = companyRepo;
        this.basicCompanyDTORepo=basicCompanyDTORepo;
        companyId = Caffeine.newBuilder().buildAsync(
                (id, execute) -> companyRepo.findById(id).toFuture()
        );
    }

    @Override
    public Flux<CompanyBasicDTO> findAllBasicDto() {
        return basicCompanyDTORepo.findAllBasicDto();
    }

    @Override
    public Flux<CompanyBasicDTO> findAllBasicDtoWhereNameLike(String title) {
        return basicCompanyDTORepo.findAllBasicDtoWhereNameLike(title);
    }

    @Override
    public Mono<Company> findById(Integer id) {
        return Mono.fromCompletionStage(companyId.get(id));
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return Mono.fromCompletionStage(companyId.asMap().remove(id)).flatMap(x->companyRepo.delete(x));
    }

    @Override
    public Mono<Company> save(Company company) {
        return companyRepo.save(company);
    }

    @Override
    public Mono<Company> update(Company company, Integer id) {
        return companyRepo.findById(id).flatMap(x -> {
            if (company.getTitle() != null) x.setTitle(company.getTitle());
            if (company.getDescr() != null) x.setDescr(company.getDescr());
            if (company.getPrev() != null) x.setPrev(company.getPrev());
            companyId.put(id, Mono.just(x).toFuture());
            return companyRepo.save(x);
        });
    }
}
