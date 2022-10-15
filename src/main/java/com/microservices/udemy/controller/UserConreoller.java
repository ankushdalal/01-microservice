package com.microservices.udemy.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.microservices.udemy.user.User;
import com.microservices.udemy.user.dao.UserDAOService;

@RestController
public class UserConreoller {

	private UserDAOService userdao;

	// Constructor Injection
	public UserConreoller(UserDAOService userdao) {
		this.userdao = userdao;
	}

	@GetMapping("/users")
	public List<User> getAlluser() {
		return userdao.findAll();
	}

	@GetMapping("/users/{id}")
	public User findUserByID(@PathVariable int id) {
		return userdao.findById(id);
	}

//	@PostMapping("/addUser")
//	public void addUSer(@RequestBody User user) {
//		userdao.addUser(user);
//	}

	@PostMapping("/users")
	public ResponseEntity<User> addUSer(@RequestBody User user) {
		User addedUser = userdao.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(addedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
