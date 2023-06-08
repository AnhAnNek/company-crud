package com.vanannek.companycrud.repository;

import com.vanannek.companycrud.entity.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
}
