package com.vanannek.companycrud.service.impl;

import com.vanannek.companycrud.entity.ProjectAssignment;
import com.vanannek.companycrud.repository.ProjAssignRepository;
import com.vanannek.companycrud.service.ProjAssignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProjAssignServiceImpl implements ProjAssignService {

    @Autowired
    private ProjAssignRepository repos;

    @Override
    public void add(ProjectAssignment assign) {
        repos.save(assign);
    }

    @Override
    public List<ProjectAssignment> getAll() {
        return repos.findAll();
    }

    @Override
    public void delete(ProjectAssignment assign) {
        String responseStr = "Invalid project id=" + assign.getId().getProjId() +
                                    " or department id=" + assign.getId().getDeptId();
        repos
            .findById(assign)
            .orElseThrow(() -> new ResponseStatusException( HttpStatus.NOT_FOUND, responseStr));

        repos.delete(assign);
    }
}
