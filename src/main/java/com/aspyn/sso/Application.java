package com.aspyn.sso;

import com.aspyn.sso.domain.AppUser;
import com.aspyn.sso.domain.Role;
import com.aspyn.sso.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	CommandLineRunner run (UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveAppUser(new AppUser(null,"eunsu" ,"eunsu","1234", new ArrayList<>()));

			userService.addRoleToUser("eunsu","ROLE_ADMIN");
		};
	}
}
