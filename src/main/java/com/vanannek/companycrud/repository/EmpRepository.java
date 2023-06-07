package com.vanannek.companycrud.repository;

import com.vanannek.companycrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Employee, Long> {
}
