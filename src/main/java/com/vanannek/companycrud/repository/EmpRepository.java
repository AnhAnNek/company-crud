package com.vanannek.companycrud.repository;

import com.vanannek.companycrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT * FROM employee WHERE id IN (SELECT department_id FROM project_assignment " +
            "WHERE project_id=:projId)", nativeQuery = true)
    List<Employee> findEmployeesInProject(@Param("projId") Long projId);
}
