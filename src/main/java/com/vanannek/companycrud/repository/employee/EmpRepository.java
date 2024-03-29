package com.vanannek.companycrud.repository.employee;

import com.vanannek.companycrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Long>, EmpReposCustom {
}
