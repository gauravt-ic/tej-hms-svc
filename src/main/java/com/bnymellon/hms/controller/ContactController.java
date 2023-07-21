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

import com.bnymellon.hms.entities.Contact;
import com.bnymellon.hms.repository.ContactRepository;

@RestController
@RequestMapping("/api/v1")
public class ContactController {
	private final ContactRepository contactRepo;

	public ContactController(ContactRepository contactRepo) {
		this.contactRepo = contactRepo;
	}

	@GetMapping("/contacts")
	public ResponseEntity<List<Contact>> getAllContacts() {
		List<Contact> lst1 = contactRepo.findAll();
		return ResponseEntity.ok().body(lst1);
	}

	@GetMapping("/contact/{id}")
	public ResponseEntity<Optional<Contact>> getContactbyid(@PathVariable(value = "id") int id) {
		Optional<Contact> lst = contactRepo.findById(id);
		return ResponseEntity.ok().body(lst);
	}

	@PostMapping("/contact")
	public ResponseEntity<Contact> createContact(@RequestBody Contact contactDetails) {
		Contact lst = contactRepo.save(contactDetails);
		return ResponseEntity.ok().body(lst);
	}

	@PutMapping("/contact/{id}")
	public ResponseEntity<Contact> updateContact(@PathVariable(value = "id") int id,
			@RequestBody Contact contactDetails) {
		Optional<Contact> con = contactRepo.findById(id);
		if (con.isPresent()) {
			Contact setCon = con.get();
			setCon.setName(contactDetails.getName());
			setCon.setEmail(contactDetails.getEmail());
			setCon.setContact(contactDetails.getContact());
			setCon.setMessage(contactDetails.getMessage());
			Contact newContact = contactRepo.save(setCon);
			return ResponseEntity.ok().body(newContact);
		} else {
			return null;
		}
	}

	@DeleteMapping("/contact/{id}")
	public ResponseEntity<String> deleteContact(@PathVariable(value = "id") int id) {
		Optional<Contact> contacttobedeleted = contactRepo.findById(id);
		if (contacttobedeleted.isPresent()) {
			Contact deletedContact = contacttobedeleted.get();
			contactRepo.delete(deletedContact);
			return ResponseEntity.ok().body("deleteContact");
		} else {
			return null;
		}
	}
}
