package Zzz3103.example.demo;

import Zzz3103.example.demo.domain.AppUser;
import Zzz3103.example.demo.domain.Role;
import Zzz3103.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		System.out.println("working baby");
	}
	@Bean
	CommandLineRunner run(UserService userService, PasswordEncoder passwordEncoder) {
		return args -> {
			userService.saveUser(new AppUser(null, "john", "john wick", "1234", new ArrayList<>()));
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.addRoleToUser("john wick", "ROLE_USER");

			userService.saveUser(new AppUser(null, "minh nguyen", "Zzz", "3103", new ArrayList<>()));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.addRoleToUser("Zzz", "ROLE_MANAGER");
		};
	}
}
