package com.vanannek.companycrud.entity;

import jakarta.persistence.*;
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
public class ProjectAssignment {
    @EmbeddedId
    private ProjAssignId id;

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProjAssignId implements Serializable {

        @Column(name = "project_id")
        private Long projID;

        @Column(name = "department_id")
        private Long deptID;
    }
}
