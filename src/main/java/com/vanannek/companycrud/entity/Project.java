package com.vanannek.companycrud.entity;

import com.vanannek.companycrud.enums.EProjStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "project")
@EnableAutoConfiguration
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "proj_name")
    private String name;

    private String details;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;

    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;

    @Column(name = "completed_date")
    @Temporal(TemporalType.TIMESTAMP)
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
