package com.vanannek.companycrud.repository.department;

import com.vanannek.companycrud.entity.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

@NoRepositoryBean
public interface DeptReposCustom {

    @Query(value = "SELECT d.* FROM department d, project_assignment pa WHERE d.id = pa.department_id " +
            "AND pa.project_id = :projId", nativeQuery = true)
    List<Department> findDepartmentsInProject(@Param("projId") Long projId);

    @Query(value = "SELECT * FROM department WHERE id NOT IN (SELECT department_id FROM project_assignment" +
            "WHERE project_id IN (SELECT project_id FROM project WHERE id <> :projId AND progress <> '100'" +
            "AND start_date <= :end AND end_date >= :start)) EXCEPT (SELECT d.* FROM department d INNER JOIN" +
            "project_assignment pa ON d.department_id=pa.department_id WHERE pa.project_id=:projId)", nativeQuery = true)
    List<Department> findDepartmentsCanAssignWork(@Param("projId") Long projId,
                                                  @Param("start") Date start,
                                                  @Param("end") Date end);
}
