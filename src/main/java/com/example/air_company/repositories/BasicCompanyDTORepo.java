package com.example.air_company.repositories;

import com.example.air_company.DTOs.CompanyBasicDTO;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;

public interface BasicCompanyDTORepo {
    Flux<CompanyBasicDTO> findAllBasicDto();
    //@Query("select  title, id from company where title like '%:title%'")
    Flux<CompanyBasicDTO> findAllBasicDtoWhereNameLike(@Param("title") String title);
}
