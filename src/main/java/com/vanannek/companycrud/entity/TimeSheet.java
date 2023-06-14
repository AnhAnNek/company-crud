package com.vanannek.companycrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.Date;

@Data
@Entity
@Table(name = "time_sheet")
@EnableAutoConfiguration
@NoArgsConstructor
@AllArgsConstructor
public class TimeSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id")
    private Long emplID;

    @Column(name = "check_in_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInTime = new Date();

    @Column(name = "check_out_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOutTime = new Date();

    @Column(name = "task_check_in_id")
    private Long taskCheckInID;
}
