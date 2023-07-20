package com.vanannek.companycrud.service.impl;

import com.vanannek.companycrud.entity.Milestone;
import com.vanannek.companycrud.entity.Task;
import com.vanannek.companycrud.repository.task.TaskRepository;
import com.vanannek.companycrud.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repos;

    @Override
    public Task add(Task task) {
        try {
            return repos.save(task);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Task update(Long taskId, Task task) {
        Optional<Task> optTask = repos.findById(taskId);
        if (optTask.isEmpty()) return null;
        try {
            task.setId(taskId);
            return repos.save(task);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
        Optional<Task> optTask = repos.findById(id);
        if (optTask.isEmpty()) return false;
        try {
            Task task = optTask.get();
            repos.delete(task);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteByProjId(Long projId) {
        List<Task> tasks = repos.findAllByProjId(projId);
        try {
            repos.deleteAll(tasks);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Task getById(Long id) {
        return repos.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found id=" + id));
    }

    @Override
    public List<Task> getByProjId(Long projId) {
        return repos.findAllByProjId(projId);
    }

    @Override
    public List<Task> getByEmpId(Long projId, Long empId) {
        return repos.findByEmpId(projId, empId);
    }

    @Override
    public List<Task> getTasksCheckOut(Long empId, Date curDate) {
        return repos.findTasksCheckOut(empId, curDate);
    }

    @Override
    public List<Task> getByMileId(Long mileId) {
        return repos.findByMileId(mileId);
    }

    @Override
    public List<Task> getTaskCompletedByMileId(Long mileId) {
        return repos.findTaskCompletedByMileId(mileId);
    }

    @Override
    public List<Task> getTasksCanAddToMile(Milestone milestone) {
        return repos.findTasksCanAddToMile(milestone);
    }
}
