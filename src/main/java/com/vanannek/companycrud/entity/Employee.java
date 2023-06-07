package com.vanannek.companycrud.entity;

import com.vanannek.companycrud.enums.EGender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
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

    private Date birthday = new Date();

    @Column(name = "identify_card")
    private String identifyCard = "";

    private String email = "";

    @Column(name = "phone_number")
    private String phoneNumber = "";

    private String address = "";

    @Column(name = "role_id")
    private Integer roleId;
}