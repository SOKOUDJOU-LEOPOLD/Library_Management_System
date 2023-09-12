package com.example.library.entity;


//import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;

@Entity
@Table(name="subscriber")
public class Subscriber {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SUB_NO", unique=true, nullable=false)
	private int subNo;

	@Column(name="SUB_ADDRESS", nullable=false, length=255)
	private String subAddress;

	@Column(name="SUB_EMAIL", nullable=false, length=255)
	private String subEmail;

	@Column(name="SUB_FNAME", nullable=false, length=255)
	private String subFname;

	@Column(name="SUB_LNAME", nullable=false, length=255)
	private String subLname;

	@Column(name="SUB_PASSWORD", nullable=false, length=255)
	private String subPassword;

	@Column(name="SUB_PHONE", nullable=false, length=255)
	private String subPhone;

	@Column(name="SUB_TYPE", length=20)
	private String subType;

	@Column(name="SUB_USERNAME", nullable=false, length=255)
	private String subUsername;

	//bi-directional many-to-one association to Borrowing
	@OneToMany(mappedBy="subscriber", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Borrowing> borrowings;

	public Subscriber() {
	}

	public int getSubNo() {
		return this.subNo;
	}

	public void setSubNo(int subNo) {
		this.subNo = subNo;
	}

	public String getSubAddress() {
		return this.subAddress;
	}

	public void setSubAddress(String subAddress) {
		this.subAddress = subAddress;
	}

	public String getSubEmail() {
		return this.subEmail;
	}

	public void setSubEmail(String subEmail) {
		this.subEmail = subEmail;
	}

	public String getSubFname() {
		return this.subFname;
	}

	public void setSubFname(String subFname) {
		this.subFname = subFname;
	}

	public String getSubLname() {
		return this.subLname;
	}

	public void setSubLname(String subLname) {
		this.subLname = subLname;
	}

	public String getSubPassword() {
		return this.subPassword;
	}

	public void setSubPassword(String subPassword) {
		this.subPassword = subPassword;
	}

	public String getSubPhone() {
		return this.subPhone;
	}

	public void setSubPhone(String subPhone) {
		this.subPhone = subPhone;
	}

	public String getSubType() {
		return this.subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getSubUsername() {
		return this.subUsername;
	}

	public void setSubUsername(String subUsername) {
		this.subUsername = subUsername;
	}

	@JsonManagedReference(value = "subscriber-borrowing")
	public List<Borrowing> getBorrowings() {
		return this.borrowings;
	}

	public void setBorrowings(List<Borrowing> borrowings) {
		this.borrowings = borrowings;
	}

	public Borrowing addBorrowing(Borrowing borrowing) {
		getBorrowings().add(borrowing);
		borrowing.setSubscriber(this);

		return borrowing;
	}

	public Borrowing removeBorrowing(Borrowing borrowing) {
		getBorrowings().remove(borrowing);
		borrowing.setSubscriber(null);

		return borrowing;
	}

}
