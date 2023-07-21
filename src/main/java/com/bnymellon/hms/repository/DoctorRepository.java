package com.bnymellon.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnymellon.hms.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

}
