package com.vanannek.companycrud.repository;

import com.vanannek.companycrud.entity.ProjectAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjAssignRepository extends JpaRepository<ProjectAssignment, ProjectAssignment.ProjAssignId> {
}
