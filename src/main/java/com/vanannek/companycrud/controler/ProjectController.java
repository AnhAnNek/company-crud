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
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Project proj) {
        projService.update(id, proj);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        projService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-projects-by-member-id/{memberId}")
    public List<Project> getProjectsByMemberId(@PathVariable Long memberId) {
        return projService.findProjectsByMemberId(memberId);
    }

    @GetMapping("/get-projects-by-owner-id/{ownerId}")
    public List<Project> getProjectsByOwnerId(@PathVariable Long ownerId) {
        return projService.findProjectsByOwnerId(ownerId);
    }
}
