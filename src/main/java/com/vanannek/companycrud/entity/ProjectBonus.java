package com.vanannek.companycrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "project_bonus")
@EnableAutoConfiguration
@NoArgsConstructor
@AllArgsConstructor
public class ProjectBonus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @Column(name = "received_date")
    private Date received;

    @Column(name = "receiver_id")
    private Long receiverId;

    @Column(name = "project_id")
    private Long projId;

    private Short percent = 0;
}
