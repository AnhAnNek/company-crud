package com.vanannek.companycrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Data
@Entity
@EnableAutoConfiguration
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private String username;
    @Column(name = "password_hash")
    private String pass;
    @Column(name = "employee_id")
    private Long empID;
}
