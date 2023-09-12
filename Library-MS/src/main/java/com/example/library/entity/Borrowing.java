package com.example.library.entity;

import java.sql.Date;
//import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="borrowing")
public class Borrowing {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BOR_ID", unique=true, nullable=false)
	private int borId;
	
	@Temporal(TemporalType.DATE)
	@Column(name="BOR_DATE", nullable=false)
	private Date borDate;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_ACTUAL_RETURNED")
	private Date dateActualReturned;

	@Column(name="FEE")
	private int fee;

	@Column(length=20)
	private String returned;

	@Temporal(TemporalType.DATE)
	@Column(name="RETURNED_DATE")
	private Date returnedDate;

	@Column(length=20)
	private String status;

	//bi-directional many-to-one association to Subscriber
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="SUB_NO", nullable=false)
	private Subscriber subscriber;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="ITEM_ID", nullable=false)
	private Item item;

	public Borrowing() {
	}

	public int getBorId() {
		return borId;
	}

	public void setBorId(int borId) {
		this.borId = borId;
	}

	public Date getBorDate() {
		return this.borDate;
	}

	public void setBorDate(Date borDate) {
		this.borDate = borDate;
	}

	public Date getDateActualReturned() {
		return this.dateActualReturned;
	}

	public void setDateActualReturned(Date dateActualReturned) {
		this.dateActualReturned = dateActualReturned;
	}

	public int getFee() {
		return this.fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getReturned() {
		return this.returned;
	}

	public void setReturned(String returned) {
		this.returned = returned;
	}

	public Date getReturnedDate() {
		return this.returnedDate;
	}

	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@JsonBackReference(value = "subscriber-borrowing")
	public Subscriber getSubscriber() {
		return this.subscriber;
	}

	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}

	@JsonBackReference(value = "item-borrowing")
	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}
