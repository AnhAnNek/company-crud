package com.vanannek.companycrud.controler;

import com.vanannek.companycrud.entity.Employee;
import com.vanannek.companycrud.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmpController {

    @Autowired
    private EmpService empService;

    @PostMapping("/add")
    public String addEmp(@RequestBody Employee emp) {
        empService.addEmp(emp);
        return "success add employee";
    }

    @GetMapping
    public List<Employee> getEmps() {
        return empService.getEmps();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody Employee emp) {
        empService.updateEmp(id, emp);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        empService.deleteEmp(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get")
    public Employee getEmp(@RequestParam Long id) {
        return empService.getEmp(id);
    }

    @GetMapping("/get-employees-in-proj/{projId}")
    public List<Employee> getEmployeesInProject(@PathVariable Long projId) {
        return empService.findByProjectId(projId);
    }
}
