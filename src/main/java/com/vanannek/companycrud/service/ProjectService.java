package com.vanannek.companycrud.service;

import com.vanannek.companycrud.entity.Project;

import java.util.List;

public interface ProjectService {
    void add(Project proj);

    List<Project> getAll();

    void update(Long id, Project proj);

    void delete(Long id);

    List<Project> findProjectsByMemberId(Long memberId);

    List<Project> findProjectsByOwnerId(Long ownerId);
}
