package com.vanannek.companycrud.service;

import com.vanannek.companycrud.entity.ProjectAssignment;

import java.util.List;

public interface ProjAssignService {
    void add(ProjectAssignment assign);

    void delete(ProjectAssignment assign);

    List<ProjectAssignment> getAll();
}
