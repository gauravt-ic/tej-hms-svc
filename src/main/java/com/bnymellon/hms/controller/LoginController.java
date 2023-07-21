package com.bnymellon.hms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnymellon.hms.entities.Login;
import com.bnymellon.hms.repository.LoginRepository;

@RestController
@RequestMapping
public class LoginController {
	private final LoginRepository loginRepo;

	public LoginController(LoginRepository loginRepo) {
		this.loginRepo = loginRepo;
	}

	@GetMapping("/logins")
	public ResponseEntity<List<Login>> getAllDoctors() {
		List<Login> lst1 = loginRepo.findAll();
		return ResponseEntity.ok().body(lst1);
	}

	@GetMapping("/login/{id}")
	public ResponseEntity<Optional<Login>> getDoctorById(@PathVariable(value = "id") int id) {
		Optional<Login> doc1 = loginRepo.findById(id);
		return ResponseEntity.ok().body(doc1);

	}

	@PostMapping("/login")
	public ResponseEntity<Login> createDoctor(@RequestBody Login loginDetails) {
		Login doc2 = loginRepo.save(loginDetails);
		return ResponseEntity.ok().body(doc2);
	}

	@PutMapping("/login/{id}")
	public ResponseEntity<Login> updateLogin(@PathVariable(value = "id") int id, @RequestBody Login loginDetails) {
		Optional<Login> log = loginRepo.findById(id);
		if (log.isPresent()) {
			Login login = log.get();
			login.setId(loginDetails.getId());
			login.setUsername(loginDetails.getUsername());
			login.setPassword(loginDetails.getPassword());
			Login newLogin = loginRepo.save(login);
			return ResponseEntity.ok().body(newLogin);
		} else {
			return null;
		}

	}

	@DeleteMapping("/login")
	public ResponseEntity<String> deleteLogin(@PathVariable(value = "id") int id) {
		Optional<Login> log = loginRepo.findById(id);
		if (log.isPresent()) {
			Login log2 = log.get();
			loginRepo.delete(log2);
			return ResponseEntity.ok().body("deleted Succefully");
		} else {
			return null;
		}

	}

}
