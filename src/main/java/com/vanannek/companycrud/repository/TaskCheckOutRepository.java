package com.vanannek.companycrud.repository;

import com.vanannek.companycrud.entity.TaskCheckOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCheckOutRepository extends JpaRepository<TaskCheckOut, TaskCheckOut.TaskCheckOutId> {
}
