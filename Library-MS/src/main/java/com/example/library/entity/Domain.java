package com.example.library.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="domain")
public class Domain {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DOM_ID")
	private int id;

	@Column(name="DOM_CODE", unique=true, nullable=false, length=20)
	private String domCode;

	@Temporal(TemporalType.DATE)
	@Column(name="DOM_DATE_CREATED")
	private Date domDateCreated;

	@Column(name="DOM_NAME", nullable=false, length=100)
	private String domName;

	//bi-directional many-to-one association to Shelf
	@OneToMany(mappedBy="domain",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Shelf> shelfs;

	public Domain() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDomCode() {
		return domCode;
	}

	public void setDomCode(String domCode) {
		this.domCode = domCode;
	}

	public Date getDomDateCreated() {
		return this.domDateCreated;
	}

	public void setDomDateCreated(Date domDateCreated) {
		this.domDateCreated = domDateCreated;
	}

	public String getDomName() {
		return this.domName;
	}

	public void setDomName(String domName) {
		this.domName = domName;
	}

	@JsonManagedReference(value="domain-shelf")
	public List<Shelf> getShelfs() {
		return this.shelfs;
	}

	public void setShelfs(List<Shelf> shelfs) {
		this.shelfs = shelfs;
	}

	public Shelf addShelf(Shelf shelf) {
		getShelfs().add(shelf);
		shelf.setDomain(this);

		return shelf;
	}

	public Shelf removeShelf(Shelf shelf) {
		getShelfs().remove(shelf);
		shelf.setDomain(null);

		return shelf;
	}
}
