package com.vanannek.companycrud.repository;

import com.vanannek.companycrud.entity.TimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSheetRepository extends JpaRepository<TimeSheet, Long> {
}
