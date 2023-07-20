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
@Table(name = "project_assignment")
@EnableAutoConfiguration
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectAssignment {
    @EmbeddedId
    private ProjAssignId id;

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProjAssignId implements Serializable {

        @Column(name = "project_id")
        private Long projId;

        @Column(name = "department_id")
        private Long deptId;
    }
}
