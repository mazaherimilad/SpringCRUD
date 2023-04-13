package com.RestApiAngular.Project.users.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestApiAngular.Project.users.bean.User;
import com.RestApiAngular.Project.users.repository.UsersRepository;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")

public class UserController {
	@Autowired
	private UsersRepository repository;

// http://localhost:8080/users
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	// http://localhost:8080/users/id
	@GetMapping("/users/{id}")

	public User getUserById(@PathVariable(value = "id") long id) {
		Optional<User> user = repository.findById(id);
		if (user.isEmpty()) {
			throw new RuntimeException("user not found with id" + id);
		}
		
		return user.get();
	}

	// POST create new resource(/users)
	@PostMapping("/users")
	public User createUSer(@RequestBody User user) {
		return repository.save(user);
	}

	// PUT Update/Replace a resource (/users/id)
	@PutMapping("users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") long id, @RequestBody User user) {
		user.setName(user.getName());
		user.setLname(user.getLname());
		user.setCodiceFiscale(user.getCodiceFiscale());
		final User updatedUser = repository.save(user);
		
		return ResponseEntity.ok(updatedUser);
	}

	// Delete delete a resource (/users/id)
	@DeleteMapping("users/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") long id) {
		Optional<User> user = repository.findById(id);

		repository.deleteById(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
