package com.vanannek.companycrud.service.Impl;

import com.vanannek.companycrud.entity.Project;
import com.vanannek.companycrud.repository.ProjectRepository;
import com.vanannek.companycrud.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository repos;

    @Override
    public void add(Project proj) {
        repos.save(proj);
    }

    @Override
    public List<Project> getAll() {
        return repos.findAll();
    }

    @Override
    public void update(Long id, Project proj) {
        repos
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid project id=" + id));
        proj.setId(id);

        repos.save(proj);
    }

    @Override
    public void delete(Long id) {
        Project proj = repos
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid project id=" + id));

        repos.delete(proj);
    }

    @Override
    public List<Project> findProjectsByMemberId(Long memberId) {
        return repos.findProjectsByMemberId(memberId);
    }

    @Override
    public List<Project> findProjectsByOwnerId(Long ownerId) {
        return repos.findProjectsByOwnerId(ownerId);
    }
}
