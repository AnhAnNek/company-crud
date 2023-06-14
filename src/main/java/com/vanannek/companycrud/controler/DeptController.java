package com.vanannek.companycrud.controler;

import com.vanannek.companycrud.entity.Department;
import com.vanannek.companycrud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/add")
    public String add(@RequestBody Department dept) {
        deptService.addDept(dept);
        return "success add department";
    }

    @GetMapping
    public List<Department> getDepts() {
        return deptService.getDepts();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Department dept) {
        deptService.updateDept(id, dept);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deptService.deleteDept(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-departments-in-proj/{projId}")
    public List<Department> getDepartmentsInProject(@PathVariable Long projId) {
        return deptService.findDepartmentsInProject(projId);
    }

    @GetMapping("/get-departments-can-assign-work")
    public List<Department> getDepartmentsCanAssignWork(
            @RequestParam Long projID,
            @RequestParam Date start,
            @RequestParam Date end
    ) {
        return deptService.findDepartmentsCanAssignWork(projID, start, end);
    }
}
