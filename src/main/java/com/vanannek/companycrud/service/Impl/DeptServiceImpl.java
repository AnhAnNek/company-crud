package com.vanannek.companycrud.service.Impl;

import com.vanannek.companycrud.entity.Department;
import com.vanannek.companycrud.repository.DeptRepository;
import com.vanannek.companycrud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {


    @Autowired
    private DeptRepository repo;

    @Override
    public void addDept(Department dept) {
        repo.save(dept);
    }

    @Override
    public List<Department> getDepts() {
        return repo.findAll();
    }

    @Override
    public void updateDept(Long id, Department dept) {
        // check weather the user is in database or not
        repo
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id=" + id));

        dept.setId(id);

        repo.save(dept);
    }

    @Override
    public void deleteDept(Long id) {
        // check weather the user is in database or not
        Department dept = repo
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id=" + id));

        repo.delete(dept);
    }
}
