package com.vanannek.companycrud.entity;

import com.vanannek.companycrud.enums.EPermission;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.math.BigDecimal;

@Data
@Entity
@EnableAutoConfiguration
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue
    private Integer id;
    private EPermission perms;
    private String title;
    private BigDecimal salary;
}
