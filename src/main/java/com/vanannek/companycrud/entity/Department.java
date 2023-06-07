package com.vanannek.companycrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Data
@Entity
@EnableAutoConfiguration
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "dept_name")
    private String name;

    @Column(name = "dept_head_id")
    private Long deptHeadId;
}
