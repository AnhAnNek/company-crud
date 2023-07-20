package com.vanannek.companycrud.entity;

import com.vanannek.companycrud.enums.EPermission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "emp_role")
@EnableAutoConfiguration
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "permission")
    private EPermission perms;

    private String title;

    private BigDecimal salary;
}
