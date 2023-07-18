package com.bnymellon.hms.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnymellon.hms.entities.User;
import com.bnymellon.hms.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	private final UserRepository userRepo;

	public UserController(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> lst1 = userRepo.findAll();
		return ResponseEntity.ok().body(lst1);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable(value = "id") int id) {
		Optional<User> user1 = userRepo.findById(id);
		return ResponseEntity.ok().body(user1);
	}

	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User userDetails) {
		User newUser = userRepo.save(userDetails);
		return ResponseEntity.ok().body(newUser);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUserByID(@PathVariable(value = "id") int id, @RequestBody User userDetails) {
		Optional<User> user1 = userRepo.findById(id);
		if (user1.isPresent()) {
			User user2 = user1.get();
			user2.setFName(userDetails.getFName());
			user2.setLName(userDetails.getLName());
			user2.setDob(userDetails.getDob());
			user2.setEmail(userDetails.getEmail());
			user2.setAge(userDetails.getAge());
			user2.setPhoneNo(userDetails.getPhoneNo());
			user2.setUserName(userDetails.getUserName());
			user2.setPassword(userDetails.getPassword());
			User user3 = userRepo.save(user2);
			return ResponseEntity.ok().body(user3);

		} else {
			return null;
		}
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable(value = "id") int id) {
		Optional<User> user1 = userRepo.findById(id);
		if (user1.isPresent()) {
			User user2 = user1.get();
			userRepo.delete(user2);
			return ResponseEntity.ok().body("Deleted User succefully");

		} else {
			return null;
		}
	}

}