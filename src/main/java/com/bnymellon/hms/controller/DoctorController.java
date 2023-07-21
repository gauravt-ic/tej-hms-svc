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

import com.bnymellon.hms.entities.Doctor;
import com.bnymellon.hms.repository.DoctorRepository;

@RestController
@RequestMapping("api/v1")
public class DoctorController {
	private final DoctorRepository docRepo;

	public DoctorController(DoctorRepository docRepo) {
		this.docRepo = docRepo;
	}

	@GetMapping("/doctors")
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		List<Doctor> lst1 = docRepo.findAll();
		return ResponseEntity.ok().body(lst1);
	}

	@GetMapping("/doctor/{id}")
	public ResponseEntity<Optional<Doctor>> getDoctorById(@PathVariable(value = "id") int id) {
		Optional<Doctor> doc1 = docRepo.findById(id);
		return ResponseEntity.ok().body(doc1);

	}

	@PostMapping("/doctor")
	public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor docDetails) {
		Doctor doc2 = docRepo.save(docDetails);
		return ResponseEntity.ok().body(doc2);
	}

	@PutMapping("/doctor/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable(value = "id") int id, @RequestBody Doctor docDetails) {
		Optional<Doctor> doc = docRepo.findById(id);
		if (doc.isPresent()) {
			Doctor doc1 = doc.get();
			doc1.setId(docDetails.getId());
			doc1.setUserName(docDetails.getUserName());
			doc1.setPassword(docDetails.getPassword());
			doc1.setSpec(docDetails.getSpec());
			doc1.setDocFees(docDetails.getDocFees());
			doc1.setRasidentialState(docDetails.getRasidentialState());
			Doctor doc3 = docRepo.save(doc1);
			return ResponseEntity.ok().body(doc3);
		} else {
			return null;
		}
	}

	@DeleteMapping("/doctor/{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable(value = "id") int id) {
		Optional<Doctor> doc = docRepo.findById(id);
		if (doc.isPresent()) {
			Doctor doc1 = doc.get();
			docRepo.delete(doc1);
			return ResponseEntity.ok().body("succesfully Deleted");
		} else {
			return null;
		}

	}

}