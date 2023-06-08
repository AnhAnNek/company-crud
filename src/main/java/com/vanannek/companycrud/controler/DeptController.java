package com.vanannek.companycrud.controler;

import com.vanannek.companycrud.entity.Department;
import com.vanannek.companycrud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/add")
    public String addEmp(@RequestBody Department dept) {
        deptService.addDept(dept);
        return "success add department";
    }

    @GetMapping
    public List<Department> getDepts() {
        return deptService.getDepts();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody Department dept) {
        deptService.updateDept(id, dept);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        deptService.deleteDept(id);

        return ResponseEntity.noContent().build();
    }
}
