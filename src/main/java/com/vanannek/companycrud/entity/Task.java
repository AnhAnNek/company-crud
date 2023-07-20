package com.vanannek.companycrud.entity;

import com.vanannek.companycrud.enums.ETaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.Date;

@Data
@Entity
@Table(name = "task")
@EnableAutoConfiguration
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String explanation;

    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;

    private String progress;

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "assignee_id")
    private Long assigneeId;

    @Column(name = "project_id")
    private String projId;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status_id")
    private ETaskStatus status;
}
