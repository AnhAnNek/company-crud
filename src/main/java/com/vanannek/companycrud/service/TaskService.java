package com.vanannek.companycrud.service;

import com.vanannek.companycrud.entity.Milestone;
import com.vanannek.companycrud.entity.Task;

import java.util.Date;
import java.util.List;

public interface TaskService {
    Task add(Task task);
    Task update(Long taskId, Task task);
    boolean delete(Long id);
    boolean deleteByProjId(Long projId);
    Task getById(Long id);
    List<Task> getByProjId(Long projId);
    List<Task> getByEmpId(Long projId, Long empId);
    List<Task> getTasksCheckOut(Long empId, Date curDate);
    List<Task> getByMileId(Long mileId);
    List<Task> getTaskCompletedByMileId(Long mileId);
    List<Task> getTasksCanAddToMile(Milestone milestone);
}
