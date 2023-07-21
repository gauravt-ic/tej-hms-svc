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
@Table(name = "tbl_doctor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "username", nullable = false)
	private String userName;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "email", nullable = false ,length = 25)
	private String email;

	@Column(name = "spec", nullable = false)
	private String spec;

	@Column(name = "docFees", nullable = false)
	private int docFees;

	@Column(name = "residentialState", nullable = false)
	private String rasidentialState;

}
