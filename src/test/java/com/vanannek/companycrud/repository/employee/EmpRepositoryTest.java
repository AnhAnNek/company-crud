package com.vanannek.companycrud.repository.employee;

import com.vanannek.companycrud.entity.Employee;
import com.vanannek.companycrud.enums.EGender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EmpRepositoryTest {

    @Autowired
    private EmpRepository repos;

    private Employee existMember;

    @BeforeEach
    public void setup() {
        Employee employeeExist = Employee.builder()
                .name("Anh An Nek")
                .gender(EGender.MALE)
                .birthday(new Date(2000, 12, 12))
                .email("anhannek@gmail.com")
                .phoneNumber("0971234124")
                .address("Số 773, Ấp 1")
                .depId(1L)
                .roleId(1)
                .build();
        repos.save(employeeExist);

        existMember = repos.findAll().get(0);
    }

    @Test
    @Order(1)
    public void saveTests() {
        Employee employee = Employee.builder()
                .name("An Nek")
                .gender(EGender.FEMALE)
                .birthday(new Date(2000, 11, 12))
                .email("Annek@gmail.com")
                .phoneNumber("0971236653")
                .address("Số 779, Ấp 9")
                .depId(1L)
                .roleId(1)
                .build();

        int beforeAddSize = repos.findAll().size();

        repos.save(employee);

        assertThat(employee.getId()).isGreaterThan(0);
        assertThat(repos.findAll().size()).isEqualTo(beforeAddSize + 1);
    }

    @Test
    @Order(2)
    public void getSingleTests() {
        Employee employee = repos.findById(existMember.getId()).get();

        assertThat(employee.getId()).isEqualTo(existMember.getId());
    }

    @Test
    @Order(3)
    public void getAllTest() {
        List<Employee> employees = repos.findAll();

        assertThat(employees.size()).isEqualTo(1);
    }

    @Test
    @Order(4)
    public void updateTests() {
        Optional<Employee> employeeOptional = repos.findById(existMember.getId());

        Employee employee = employeeOptional.get();
        String emailExpected = "val@gmail.com";

        employee.setEmail(emailExpected);
        Employee updated = repos.save(employee);

        assertThat(updated.getEmail()).isEqualTo(emailExpected);
    }

    @Test
    @Order(5)
    public void deleteTests() {
        Employee employee = repos.findById(existMember.getId()).orElse(null);

        assertThat(employee).isNotNull();

        repos.delete(employee);

        Optional<Employee> employeeOptional = repos.findById(employee.getId());

        assertThat(employeeOptional).isNotPresent();
    }
}