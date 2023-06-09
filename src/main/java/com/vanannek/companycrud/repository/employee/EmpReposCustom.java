package com.vanannek.companycrud.repository.employee;

import com.vanannek.companycrud.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;

@NoRepositoryBean
public interface EmpReposCustom {

    @Query(value = "SELECT * FROM employee WHERE id IN (SELECT department_id FROM project_assignment " +
            "WHERE project_id=:projId)", nativeQuery = true)
    List<Employee> findEmployeesInProject(@Param("projId") Long projId);
}
