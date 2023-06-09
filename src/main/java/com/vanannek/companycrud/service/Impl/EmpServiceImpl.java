package com.vanannek.companycrud.service.Impl;

import com.vanannek.companycrud.entity.Employee;
import com.vanannek.companycrud.repository.EmpRepository;
import com.vanannek.companycrud.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpRepository repos;

    @Override
    public void addEmp(Employee emp) {
        repos.save(emp);
    }

    @Override
    public List<Employee> getEmps() {
        return repos.findAll();
    }

    @Override
    public void updateEmp(Long id, Employee emp) {
        repos
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid emp id=" + id));
        emp.setId(id);

        repos.save(emp);
    }

    @Override
    public void deleteEmp(Long id) {
        Employee emp = repos
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid emp id=" + id));

        repos.delete(emp);
    }

    @Override
    public Employee getEmp(Long id) {
        return repos
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid emp id=" + id));
    }

    @Override
    public List<Employee> findEmployeesInProject(Long projId) {
        return repos.findEmployeesInProject(projId);
    }
}
