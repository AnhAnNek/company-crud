package com.vanannek.companycrud.repository;

import com.vanannek.companycrud.entity.MileTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MileTaskRepository extends JpaRepository<MileTask, MileTask.MileTaskId> {
}
