package com.aspyn.sso.service;

import com.aspyn.sso.domain.AppUser;
import com.aspyn.sso.domain.Role;

import java.util.List;

public interface UserService {
    AppUser saveAppUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String userName, String roleName);
    AppUser getUser(String userName);
    List<AppUser> getUsers();
}
