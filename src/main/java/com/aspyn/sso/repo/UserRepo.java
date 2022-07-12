package com.aspyn.sso.repo;

import com.aspyn.sso.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser,Long> {

    AppUser findByUserName(String userNamne);
}
