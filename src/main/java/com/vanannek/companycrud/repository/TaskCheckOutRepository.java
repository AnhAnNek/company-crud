package com.vanannek.companycrud.repository;

import com.vanannek.companycrud.entity.TaskCheckOut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskCheckOutRepository extends JpaRepository<TaskCheckOut, TaskCheckOut.TaskCheckOutId> {
}
