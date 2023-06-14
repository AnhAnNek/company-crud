package com.vanannek.companycrud.service.impl;

import com.vanannek.companycrud.entity.Role;
import com.vanannek.companycrud.repository.RoleRepository;
import com.vanannek.companycrud.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repos;

    @Override
    public void addRole(Role role) {
        repos.save(role);
    }

    @Override
    public void updateRole(Integer id, Role role) {
        repos
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid role id =" + id));
        role.setId(id);

        repos.save(role);
    }

    @Override
    public void deleteRole(Integer id) {
        Role role = repos
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid role id =" + id));
        role.setId(id);

        repos.delete(role);
    }

    @Override
    public List<Role> getRoles() {
        return repos.findAll();
    }
}
