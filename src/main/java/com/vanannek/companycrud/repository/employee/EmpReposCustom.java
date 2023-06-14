package com.vanannek.companycrud.repository.employee;

import com.vanannek.companycrud.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;

@NoRepositoryBean
public interface EmpReposCustom {

    @Query(value = "SELECT e.* FROM employee e JOIN `role` r ON e.role_id = r.id " +
            "WHERE r.permission <> 1", nativeQuery = true)
    List<Employee> findWithoutManagers();

    @Query(value = "SELECT * FROM employee WHERE department_id=:deptId", nativeQuery = true)
    List<Employee> findByDepartmentId(@Param("deptId") Long deptId);

    @Query(value = "SELECT * FROM employee WHERE id IN (SELECT department_id FROM project_assignment " +
            "WHERE project_id=:projId)", nativeQuery = true)
    List<Employee> findByProjectId(@Param("projId") Long projId);
}

