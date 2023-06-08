package com.vanannek.companycrud.service;

import com.vanannek.companycrud.entity.Project;

import java.util.List;

public interface ProjectService {
    void add(Project proj);

    List<Project> getAll();

    void update(Integer id, Project proj);

    void delete(Integer id);

    List<Project> findByOwnerId(Long ownerId);
}
