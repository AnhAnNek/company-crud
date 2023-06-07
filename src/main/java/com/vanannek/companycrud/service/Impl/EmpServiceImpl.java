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
    private EmpRepository repo;

    @Override
    public void addEmp(Employee emp) {
        repo.save(emp);
    }

    @Override
    public List<Employee> getEmps() {
        return repo.findAll();
    }

    @Override
    public void updateEmp(Long id, Employee emp) {
        // check weather the user is in database or not
        repo
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id=" + id));
        emp.setId(id);

        repo.save(emp);
    }

    @Override
    public void deleteEmp(Long id) {
        // check weather the user is in database or not
        Employee emp = repo
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id=" + id));

        repo.delete(emp);
    }
}
