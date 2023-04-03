package net.example.springboot.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.example.springboot.entity.Role;
import net.example.springboot.entity.User;
import net.example.springboot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class UserController {
	private UserService userService;
	
	@GetMapping()
	public ResponseEntity<String> sayHello(){
		return ResponseEntity.ok("Hello");
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(){
		return ResponseEntity.ok().body(userService.getUser());
	}

	@PostMapping("/users/save")
	public ResponseEntity<User> saveUsers(@RequestBody User user){
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/home/users/save").toUriString());
		return ResponseEntity.created(uri).body(userService.saveUser(user));
	}

	@PostMapping("/roles/save")
	public ResponseEntity<Role> saveRole(@RequestBody Role role){
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/home/roles/save").toUriString());
		return ResponseEntity.created(uri).body(userService.saveRole(role));
	}

	@PostMapping("/roles/add-to-user")
	public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
		userService.addRoleToUser(form.getUserName(), form.getRoleName());
		return ResponseEntity.ok().build();
	}
}
@Data
class RoleToUserForm{
	private String userName;
	private String roleName;
}
