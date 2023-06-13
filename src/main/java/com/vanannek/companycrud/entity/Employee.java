package com.vanannek.companycrud.entity;

import com.vanannek.companycrud.enums.EGender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "employee")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String name = "";

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "gender")
    private EGender gender;

    @Temporal(TemporalType.DATE)
    private Date birthday = new Date();

    @Column(name = "identify_card")
    private String identifyCard = "";

    private String email = "";

    @Column(name = "phone_number")
    private String phoneNumber = "";

    private String address = "";

    @Column(name = "department_id")
    private Long deptId;

    @Column(name = "role_id")
    private Integer roleId;
}
