package com.vanannek.companycrud.entity;

import com.vanannek.companycrud.enums.EProjStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EnableAutoConfiguration
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String details;

    @Column(name = "created_date")
    private Date created;

    @Column(name = "start_date")
    private Date start;

    @Column(name = "end_date")
    private Date end;

    @Column(name = "completed_date")
    private Date completed;

    private String progress;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status_id")
    private EProjStatus status;

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "bonus_salary")
    private BigDecimal bonusSalary;
}