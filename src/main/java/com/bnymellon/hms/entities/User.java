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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "firstName", nullable = false)
	private String fName;

	@Column(name = "lastName", nullable = false)
	private String lName;

	@Column(name = "dob", nullable = false)
	private String dob;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "age", nullable = false)
	private int age;

	@Column(name = "phoneNo", nullable = false)
	private int phoneNo;

	@Column(name = "userName", nullable = false)
	private String userName;

	@Column(name = "password", nullable = false)
	private String password;

}
