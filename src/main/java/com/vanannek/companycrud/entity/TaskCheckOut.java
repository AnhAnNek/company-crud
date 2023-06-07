package com.vanannek.companycrud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class TaskCheckOut {
    @Id
    @Column(name = "time_sheet_id")
    private Long timeShtID;

    @Column(name = "task_id")
    private Long taskID;

    @Column(name = "updated_date")
    private Date updated;

    private Short progress;
}
