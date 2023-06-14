package com.vanannek.companycrud.controler;

import com.vanannek.companycrud.entity.Role;
import com.vanannek.companycrud.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/add")
    public String add(@RequestBody Role role) {
        roleService.addRole(role);
        return "add role success";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Integer id, @RequestBody Role role) {
        roleService.updateRole(id, role);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        roleService.deleteRole(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Role> getAll() {
        return roleService.getRoles();
    }
}
