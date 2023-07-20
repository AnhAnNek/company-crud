package com.vanannek.companycrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.Date;

@Data
@Entity
@Table(name = "milestone")
@EnableAutoConfiguration
@NoArgsConstructor
@AllArgsConstructor
public class Milestone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String explanation;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date start = new Date();

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date end = new Date();

    @Temporal(TemporalType.DATE)
    @Column(name = "completed_date")
    private Date completed = new Date();

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "project_id")
    private Long projId;
}
