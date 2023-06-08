package com.vanannek.companycrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.Date;

@Data
@Entity
@EnableAutoConfiguration
@NoArgsConstructor
@AllArgsConstructor
public class Milestone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String explanation;

    @Column(name = "start_date")
    private Date start = new Date();

    @Column(name = "end_date")
    private Date end = new Date();

    @Column(name = "completed_date")
    private Date completed = new Date();

    @Column(name = "owner_id")
    private String ownerId;

    @Column(name = "project_id")
    private String projId;
}
