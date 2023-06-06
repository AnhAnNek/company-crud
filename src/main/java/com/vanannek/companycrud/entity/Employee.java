package com.vanannek.companycrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name = "";
    private String gender = "";
    private Date birthday = new Date();
    @Column(name = "identify_card")
    private String identifyCard = "";
    private String email = "";
    @Column(name = "phone_number")
    private String phoneNumber = "";
    private String address = "";
    @Column(name = "department_id", insertable = false, updatable = false)
    private Long deptID;
    private Long roleID;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account = new Account();
    @ManyToOne
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private Role role = new Role();
}
