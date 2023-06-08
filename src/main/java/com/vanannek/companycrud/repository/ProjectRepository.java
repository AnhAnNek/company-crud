package com.vanannek.companycrud.repository;

import com.vanannek.companycrud.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Query(value = "SELECT * FROM project WHERE owner_id=:ownerId", nativeQuery = true)
    List<Project> findByOwnerId(@Param("ownerId") Long ownerId);
}
