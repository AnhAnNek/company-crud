package com.vanannek.companycrud.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.Serializable;

@Data
@Entity
@Table(name = "mile_task")
@EnableAutoConfiguration
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MileTask {
    @EmbeddedId
    private MileTaskId id;

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MileTaskId implements Serializable {

        @Column(name = "mile_id")
        private Long mileId;

        @Column(name = "task_id")
        private Long taskId;
    }
}
