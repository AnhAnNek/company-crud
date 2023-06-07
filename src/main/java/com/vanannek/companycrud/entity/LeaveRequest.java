package com.vanannek.companycrud.entity;

import com.vanannek.companycrud.enums.ELeavStatus;
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
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id = "";

    private String reason = "";

    private String notes = "";

    @Column(name = "created_date")
    private Date created = new Date();

    @Column(name = "start_date")
    private Date start = new Date();

    @Column(name = "end_date")
    private Date end = new Date();

    @Column(name = "status_id")
    @Enumerated(EnumType.ORDINAL)
    private ELeavStatus status = ELeavStatus.UNAPPROVED;

    @Column(name = "requester_id")
    private Long requesterId;

    @Column(name = "approver_id")
    private Long approverId;

    private String response = "";
}

