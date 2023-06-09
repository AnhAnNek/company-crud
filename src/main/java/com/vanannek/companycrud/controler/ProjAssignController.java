package com.vanannek.companycrud.controler;

import com.vanannek.companycrud.entity.ProjectAssignment;
import com.vanannek.companycrud.service.ProjAssignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project-assignment")
public class ProjAssignController {

    @Autowired
    private ProjAssignService assignService;

    @PostMapping("/add")
    public String add(@RequestBody ProjectAssignment assign) {
        assignService.add(assign);
        return "success add project assignment";
    }

    @GetMapping
    public List<ProjectAssignment> getAll() {
        return assignService.getAll();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody ProjectAssignment assign) {
        assignService.delete(assign);

        return ResponseEntity.noContent().build();
    }
}
