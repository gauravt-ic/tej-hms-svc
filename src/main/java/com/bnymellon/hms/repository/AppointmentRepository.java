package com.bnymellon.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnymellon.hms.entities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
