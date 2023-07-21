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

import com.bnymellon.hms.entities.Patient;
import com.bnymellon.hms.repository.PatientRepository;

@RestController
@RequestMapping
public class PatientController {
	private final PatientRepository patientRepo;

	public PatientController(PatientRepository patientRepo) {
		this.patientRepo = patientRepo;
	}

	@GetMapping("/patients")
	public ResponseEntity<List<Patient>> getAllPatient() {
		List<Patient> patients = patientRepo.findAll();
		return ResponseEntity.ok().body(patients);
	}

	@GetMapping("/patient/{id}")
	public ResponseEntity<Optional<Patient>> getPatientByID(@PathVariable(value = "id") int id) {
		Optional<Patient> patient = patientRepo.findById(id);
		return ResponseEntity.ok().body(patient);
	}

	@PostMapping("/patient")
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patientDetails) {
		Patient patient = patientRepo.save(patientDetails);
		return ResponseEntity.ok().body(patient);
	}

	@PutMapping("/patient/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id") int id,
			@RequestBody Patient patientDetails) {
		Optional<Patient> patient = patientRepo.findById(id);
		if (patient.isPresent()) {
			Patient patient2 = patient.get();
			patient2.setId(patientDetails.getId());
			patient2.setFname(patientDetails.getFname());
			patient2.setLname(patientDetails.getLname());
			patient2.setGender(patientDetails.getGender());
			patient2.setEmail(patientDetails.getEmail());
			patient2.setContact(patientDetails.getContact());
			Patient newpatient = patientRepo.save(patient2);
			return ResponseEntity.ok().body(newpatient);
		} else {
			return null;
		}
	}

	@DeleteMapping("/patient")
	public ResponseEntity<String> deletePatient(@PathVariable(value = "id") int id) {
		Optional<Patient> patient = patientRepo.findById(id);
		if (patient.isPresent()) {
			Patient newPatient = patient.get();
			patientRepo.delete(newPatient);
			return ResponseEntity.ok().body(" Patient Deleted Succefully");

		} else {
			return null;
		}

	}

}
