package net.example.springboot;

import net.example.springboot.entity.Role;
import net.example.springboot.entity.User;
import net.example.springboot.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class UsersApplication {

	public static void main(String[] args) {

		SpringApplication.run(UsersApplication.class, args);
	}
	CommandLineRunner run(UserService userService){
		return args ->{
			userService.saveRole(new Role(1, "ROLE_USER"));

			userService.saveUser(new User(1, "John", "John123", "pochi", new ArrayList<>()));

			userService.addRoleToUser("John", "ROLE_USER");
		};
	}
}
