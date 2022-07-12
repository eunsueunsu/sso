package com.aspyn.sso.service;

import com.aspyn.sso.domain.AppUser;
import com.aspyn.sso.domain.Role;
import com.aspyn.sso.repo.RoleRepo;
import com.aspyn.sso.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService , UserDetailsService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser user = userRepo.findByUserName(userName);
        if(user == null){
            log.error("해당 유저 없음");
            throw new UsernameNotFoundException("User not found");

        }else{
            log.info("User found : {}", userName);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new User(user.getUserName(),user.getPassword(),authorities);

    }
    @Override
    public AppUser saveAppUser(AppUser user) {
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
    AppUser user = userRepo.findByUserName(userName);
    Role role = roleRepo.findByName(roleName);
    user.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String userName) {
        return userRepo.findByUserName(userName);
    }

    @Override
    public List<AppUser> getUsers() {
        return userRepo.findAll();
    }


}
