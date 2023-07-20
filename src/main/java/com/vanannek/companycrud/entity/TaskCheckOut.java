package com.vanannek.companycrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "task_check_out")
@EnableAutoConfiguration
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskCheckOut {
    @EmbeddedId
    private TaskCheckOutId id;

    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    private Integer progress;

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TaskCheckOutId implements Serializable {

        @Column(name = "time_sheet_id")
        private Long timeShtID;

        @Column(name = "task_id")
        private Long taskID;
    }
}
