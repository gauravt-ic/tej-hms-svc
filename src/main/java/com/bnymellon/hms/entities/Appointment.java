package com.bnymellon.hms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbL_appointment")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "patient_id")
	private int pid;

	@Column(name = "fname")
	private String fname;

	@Column(name = "lname")
	private String lname;

	@Column(name = "gender")
	private String gender;

	@Column(name = "email")
	private String email;

	@Column(name = "contact")
	private int contact;

	@Column(name = "doctor")
	private String doctor;

	@Column(name = "doctorFees")
	private int doctorFees;

	@Column(name = "appdate")
	private String appdate;

	@Column(name = "apptime")
	private String apptime;

	@Column(name = "userStatus")
	private String userStatus;

	@Column(name = "doctorStatus")
	private String doctorStatus;

}
