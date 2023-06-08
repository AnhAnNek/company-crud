package com.vanannek.companycrud.controler;

import com.vanannek.companycrud.entity.Project;
import com.vanannek.companycrud.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projService;

    @PostMapping("/add")
    public String add(@RequestBody Project proj) {
        projService.add(proj);
        return "success add project";
    }

    @GetMapping
    public List<Project> getAll() {
        return projService.getAll();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Project proj) {
        projService.update(id, proj);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        projService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-by-owner")
    public List<Project> getByEmployeeId(@RequestParam Long ownerId) {
        return projService.findByOwnerId(ownerId);
    }
}
