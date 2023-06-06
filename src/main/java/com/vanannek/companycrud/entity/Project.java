package com.vanannek.companycrud.entity;

import com.vanannek.companycrud.enums.EProjStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@EnableAutoConfiguration
@Table(name = "projects")
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String details;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "completed_date")
    private Date completedDate;
    private String progress;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_id")
    private EProjStatus status;
    @Column(name = "owner_id")
    private Integer ownerID;
    @Column(name = "bonus_salary")
    private BigDecimal bonusSalary;
}
