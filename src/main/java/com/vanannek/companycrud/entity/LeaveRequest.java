package com.vanannek.companycrud.entity;

import com.vanannek.companycrud.enums.ELeavStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.text.DateFormat;
import java.util.Date;

@Data
@Entity
@Table(name = "leave_request")
@EnableAutoConfiguration
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reason = "";

    private String notes = "";

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date created = new Date();

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date start = new Date();

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date end = new Date();

    @Column(name = "status_id")
    @Enumerated(EnumType.STRING)
    private ELeavStatus status = ELeavStatus.UNAPPROVED;

    @Column(name = "requester_id")
    private Long requesterId;

    @Column(name = "approver_id")
    private Long approverId;

    private String response = "";
}

