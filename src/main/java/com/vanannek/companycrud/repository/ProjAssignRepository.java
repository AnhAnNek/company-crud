package com.vanannek.companycrud.repository;

import com.vanannek.companycrud.entity.ProjectAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjAssignRepository extends JpaRepository<ProjectAssignment, ProjectAssignment> {
}
