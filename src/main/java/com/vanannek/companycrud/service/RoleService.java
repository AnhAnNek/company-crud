package com.vanannek.companycrud.service;

import com.vanannek.companycrud.entity.Role;

import java.util.List;

public interface RoleService {
    void addRole(Role role);

    void updateRole(Integer id, Role role);

    void deleteRole(Integer id);

    List<Role> getRoles();
}
