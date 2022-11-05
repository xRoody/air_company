package com.example.air_company.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table("company_rew")
public class Review {
    @Id
    private Long id;
    @Column("company_id")
    private Integer companyId;
    @Column("user_id")
    private Integer userId;
    private String info;
    @Column("rew_rating")
    private Double reviewRating;
    @Column("set_rating")
    private Double setRating;
    @Column("ticket_id")
    private Long ticketId;
    @Column("create_time")
    private LocalDateTime dateTime;
}
