package com.vanannek.companycrud.repository;

import com.vanannek.companycrud.entity.ProjectBonus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjBonusRepository extends JpaRepository<ProjectBonus, Long> {
}
