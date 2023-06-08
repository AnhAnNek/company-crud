package com.vanannek.companycrud.repository;

import com.vanannek.companycrud.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepository extends JpaRepository<Department, Long> {
}
