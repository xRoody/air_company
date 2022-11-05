package com.example.air_company.repositories.impl;

import com.example.air_company.DTOs.CompanyBasicDTO;
import com.example.air_company.repositories.BasicCompanyDTORepo;
import lombok.AllArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@AllArgsConstructor
public class BasicCompanyDTORepoImpl implements BasicCompanyDTORepo {
    private DatabaseClient databaseClient;

    @Override
    public Flux<CompanyBasicDTO> findAllBasicDto() {
        return databaseClient.sql("select  title, id from company")
                .map((row, metadata) -> CompanyBasicDTO
                        .builder()
                        .title(row.get("title", String.class))
                        .id(row.get("id", Integer.class))
                        .build()
                ).all();
    }

    @Override
    public Flux<CompanyBasicDTO> findAllBasicDtoWhereNameLike(String title) {
        return databaseClient.sql("with p2 as (select  id, title from company where title like :title2 except select   id,title from company where title = :title1) select id, title from company where title = :title1 union all  select id, title from p2")
                .bind("title1", title)
                .bind("title2", "%"+title+"%")
                .map((row, metadata) -> CompanyBasicDTO
                        .builder()
                        .title(row.get("title", String.class))
                        .id(row.get("id", Integer.class))
                        .build()
                ).all();
    }
}
