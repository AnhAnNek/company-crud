package com.vanannek.companycrud.repository;

import com.vanannek.companycrud.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query(value = "SELECT * FROM project WHERE id IN (SELECT project_assignment pa, employee e " +
            "WHERE pa.department_id = e.department_id AND e.id=:memberId)", nativeQuery = true)
    List<Project> findProjectsByMemberId(Long memberId);

    @Query(value = "SELECT * FROM project WHERE owner_id=:ownerId", nativeQuery = true)
    List<Project> findProjectsByOwnerId(Long ownerId);
}
