package com.vanannek.companycrud.service;

import com.vanannek.companycrud.entity.Employee;

import java.util.List;

public interface EmpService {
    void addEmp(Employee emp);

    List<Employee> getEmps();

    void updateEmp(Long id, Employee emp);

    void deleteEmp(Long id);

    Employee getEmp(Long id);
}
