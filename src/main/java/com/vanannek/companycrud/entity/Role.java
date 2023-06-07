package com.vanannek.companycrud.entity;

import com.vanannek.companycrud.enums.EPermission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.math.BigDecimal;

@Data
@Entity
@EnableAutoConfiguration
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue
    private Integer id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "permission")
    private EPermission perms;

    private String title;

    private BigDecimal salary;
}
