package com.vanannek.companycrud.service;

import com.vanannek.companycrud.entity.Department;

import java.util.Date;
import java.util.List;

public interface DeptService {
    void addDept(Department dept);

    List<Department> getDepts();

    void updateDept(Long id, Department dept);

    void deleteDept(Long id);

    List<Department> findDepartmentsInProject(Long projId);

    List<Department> findDepartmentsCanAssignWork(Long projId, Date start, Date end);
}
