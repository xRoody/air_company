package com.example.air_company.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class Plane {
    @Id
    private String id;
    @Column("sit_count")
    private Integer sitCount;
    @Column("model_type ")
    private Integer modelType;
    @Column("company_id")
    private Integer companyId;
}
