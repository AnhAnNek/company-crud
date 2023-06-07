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
public class Account {
    @Id
    @Column(name = "acc_user")
    private String username;

    @Column(name = "acc_pass")
    private String pass;

    @Column(name = "employee_id")
    private Long empId;
}
