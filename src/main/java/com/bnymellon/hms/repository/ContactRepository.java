package com.bnymellon.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnymellon.hms.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
