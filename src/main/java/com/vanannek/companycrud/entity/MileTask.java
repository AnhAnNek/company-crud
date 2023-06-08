package com.vanannek.companycrud.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.Serializable;

@Data
@Entity
@EnableAutoConfiguration
@NoArgsConstructor
@AllArgsConstructor
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
