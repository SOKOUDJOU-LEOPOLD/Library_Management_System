package com.example.library.entity;

//import java.sql.Date;
//import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;

@Entity
@Table(name="registration")
public class Registration {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="REG_NO", unique=true, nullable=false)
	private int id;

	@Column(name="REG_ADDRESS", nullable=false, length=255)
	private String regAddress;

	@Column(name="REG_EMAIL", nullable=false, length=255)
	private String regEmail;

	@Column(name="REG_FNAME", nullable=false, length=255)
	private String regFname;

	@Column(name="REG_LNAME", nullable=false, length=255)
	private String regLname;

	@Column(name="REG_PASSWORD", nullable=false, length=255)
	private String regPassword;

	@Column(name="REG_PHONE", nullable=false, length=255)
	private String regPhone;

	@Column(name="REG_USERNAME", nullable=false, length=255)
	private String regUsername;

	public Registration() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegAddress() {
		return this.regAddress;
	}

	public void setRegAddress(String regAddress) {
		this.regAddress = regAddress;
	}

	public String getRegEmail() {
		return this.regEmail;
	}

	public void setRegEmail(String regEmail) {
		this.regEmail = regEmail;
	}

	public String getRegFname() {
		return this.regFname;
	}

	public void setRegFname(String regFname) {
		this.regFname = regFname;
	}

	public String getRegLname() {
		return this.regLname;
	}

	public void setRegLname(String regLname) {
		this.regLname = regLname;
	}

	public String getRegPassword() {
		return this.regPassword;
	}

	public void setRegPassword(String regPassword) {
		this.regPassword = regPassword;
	}

	public String getRegPhone() {
		return this.regPhone;
	}

	public void setRegPhone(String regPhone) {
		this.regPhone = regPhone;
	}

	public String getRegUsername() {
		return this.regUsername;
	}

	public void setRegUsername(String regUsername) {
		this.regUsername = regUsername;
	}
}
