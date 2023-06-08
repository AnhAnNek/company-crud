package com.vanannek.companycrud.repository;

import com.vanannek.companycrud.entity.MileTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MileTaskRepository extends JpaRepository<MileTask, MileTask.MileTaskId> {
}
