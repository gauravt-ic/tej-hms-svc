package com.bnymellon.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnymellon.hms.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
