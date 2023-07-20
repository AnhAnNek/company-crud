package com.vanannek.companycrud.controler;

import com.vanannek.companycrud.entity.Milestone;
import com.vanannek.companycrud.entity.Task;
import com.vanannek.companycrud.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public String add(@RequestBody Task task) {
        taskService.add(task);
        return "success add employee";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Task task) {
        taskService.update(id, task);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        taskService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get")
    public Task getById(@RequestParam Long id) {
        return taskService.getById(id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteByProjId(@RequestParam Long projId) {
        taskService.deleteByProjId(projId);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get")
    public List<Task> getByProjId(@RequestParam("projId") Long projId) {
        return taskService.getByProjId(projId);
    }

    @GetMapping("/get")
    public List<Task> getByEmpId(@RequestParam("projId") Long projId, @RequestParam("empId") Long empId) {
        return taskService.getByEmpId(projId, empId);
    }

    @GetMapping("/get")
    public List<Task> getTasksCheckOut(@RequestParam("empId") Long empId, @RequestParam("curDate") Date curDate) {
        return taskService.getTasksCheckOut(empId, curDate);
    }

    @GetMapping("/get")
    public List<Task> getByMileId(@RequestParam("mileId") Long mileId) {
        return taskService.getByMileId(mileId);
    }

    @GetMapping("/get")
    public List<Task> getTaskCompletedByMileId(@RequestParam("mileId") Long mileId) {
        return taskService.getTaskCompletedByMileId(mileId);
    }

    @GetMapping("/get")
    public List<Task> getTasksCanAddToMile(@RequestBody Milestone milestone) {
        return taskService.getTasksCanAddToMile(milestone);
    }
}
