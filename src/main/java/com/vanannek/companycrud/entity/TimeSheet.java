package com.vanannek.companycrud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class TimeSheet {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "employee_id")
    private Long emplID;

    @Column(name = "check_in_time")
    private Date checkInTime = new Date();

    @Column(name = "check_out_time")
    private Date checkOutTime = new Date();

    @Column(name = "task_check_in_id")
    private Long taskCheckInID;
}