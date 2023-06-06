package com.vanannek.companycrud.entity;

import com.vanannek.companycrud.enums.ETaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.Date;

@Data
@Entity
@Table(name = "tasks")
@EnableAutoConfiguration
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String explanation;
    @Column(name = "start_date")
    private Date startDate;
    private Date deadline;
    private String progress;
    @Column(name = "owner_id")
    private String ownerID;
    @Column(name = "employee_id")
    private String employeeID;
    @Column(name = "project_id")
    private String projectID;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_id")
    private ETaskStatus status;
    private Employee owner = new Employee();
    private Employee assignedEmployee = new Employee();
}
