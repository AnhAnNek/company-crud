package com.vanannek.companycrud.repository.project;

import com.vanannek.companycrud.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ProjectReposCustom {

    @Query(value = "SELECT * FROM project WHERE id IN (SELECT project_assignment pa, employee e " +
            "WHERE pa.department_id = e.department_id AND e.id=:memberId)", nativeQuery = true)
    List<Project> findProjectsByMemberId(Long memberId);

    @Query(value = "SELECT * FROM project WHERE owner_id=:ownerId", nativeQuery = true)
    List<Project> findProjectsByOwnerId(Long ownerId);
}
