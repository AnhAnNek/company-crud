package com.vanannek.companycrud.repository;

import com.vanannek.companycrud.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
