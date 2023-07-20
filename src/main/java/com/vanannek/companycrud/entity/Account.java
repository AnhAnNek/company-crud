package com.vanannek.companycrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Data
@Entity
@Table(name = "account")
@EnableAutoConfiguration
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Column(name = "acc_user")
    private String username;

    @Column(name = "acc_pass")
    private String pass;

    @Id
    @Column(name = "employee_id")
    private Long empId;
}
