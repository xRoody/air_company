package com.example.air_company.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class Company {
    @Id
    private Integer id;
    private String title;
    private String descr;
    private String prev;
}
