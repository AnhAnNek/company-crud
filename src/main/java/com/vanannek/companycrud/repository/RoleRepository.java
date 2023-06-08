package com.vanannek.companycrud.repository;

import com.vanannek.companycrud.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
