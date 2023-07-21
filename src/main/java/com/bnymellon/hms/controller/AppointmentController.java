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

import com.bnymellon.hms.entities.Appointment;
import com.bnymellon.hms.repository.AppointmentRepository;

@RestController
@RequestMapping("/api/v1")

public class AppointmentController {

	private final AppointmentRepository appRepo;

	public AppointmentController(AppointmentRepository appRepo) {
		this.appRepo = appRepo;
	}

	@GetMapping("/appointments")
	public ResponseEntity<List<Appointment>> getAllAppointments() {
		List<Appointment> app = appRepo.findAll();
		return ResponseEntity.ok().body(app);
	}

	@GetMapping("/appointment/{id}")
	public ResponseEntity<Optional<Appointment>> getAppointmentById(@PathVariable(value = "id") int id) {
		Optional<Appointment> app = appRepo.findById(id);
		return ResponseEntity.ok().body(app);

	}

	@PostMapping("/appointment")
	public ResponseEntity<Appointment> createDoctor(@RequestBody Appointment appDetails) {
		Appointment app2 = appRepo.save(appDetails);
		return ResponseEntity.ok().body(app2);
	}

	@PutMapping("/appointment/{id}")
	public ResponseEntity<Appointment> updateDoctor(@PathVariable(value = "id") int id,
			@RequestBody Appointment appDetails) {
		Optional<Appointment> app2 = appRepo.findById(id);
		if (app2.isPresent()) {
			Appointment app = app2.get();
			app.setFname(appDetails.getFname());
			app.setLname(appDetails.getLname());
			app.setGender(appDetails.getGender());
			app.setEmail(appDetails.getEmail());
			app.setContact(appDetails.getContact());
			app.setDoctor(appDetails.getDoctor());
			app.setDoctorFees(appDetails.getDoctorFees());
			app.setAppdate(appDetails.getAppdate());
			app.setApptime(appDetails.getApptime());
			app.setUserStatus(appDetails.getUserStatus());
			app.setDoctorStatus(appDetails.getDoctorStatus());
			Appointment newAppointment = appRepo.save(app);
			return ResponseEntity.ok().body(newAppointment);
		} else {
			return null;
		}

	}

	@DeleteMapping("/appointment/{id}")
	public ResponseEntity<String> deleteappointment(@PathVariable(value = "id") int id) {
		Optional<Appointment> app = appRepo.findById(id);
		if (app.isPresent()) {
			Appointment deletedAppointment = app.get();
			appRepo.delete(deletedAppointment);
			return ResponseEntity.ok().body("succesfully Deleted");
		} else {
			return null;
		}

	}

}
