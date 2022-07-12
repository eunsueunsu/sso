package com.aspyn.sso.repo;

import com.aspyn.sso.domain.AppUser;
import com.aspyn.sso.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByName(String name);

}
