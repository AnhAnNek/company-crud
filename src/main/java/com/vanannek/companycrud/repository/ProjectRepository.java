package com.vanannek.companycrud.repository;

import com.vanannek.companycrud.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
