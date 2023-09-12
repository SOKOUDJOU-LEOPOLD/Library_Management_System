package com.example.library.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="library")
public class Library {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIB_ID")
	private int id;

	@Column(name="LIB_CODE", unique=true, nullable=false, length=10)
	private String libCode;

	@Temporal(TemporalType.DATE)
	@Column(name="LIB_DATE_CREATED")
	private Date libDateCreated;

	@Column(name="LIB_NAME", nullable=false, length=100)
	private String libName;

	//bi-directional many-to-one association to Shelf
	@OneToMany(mappedBy="library",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Shelf> shelfs;

	public Library() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibCode() {
		return libCode;
	}

	public void setLibCode(String libCode) {
		this.libCode = libCode;
	}

	public Date getLibDateCreated() {
		return this.libDateCreated;
	}

	public void setLibDateCreated(Date libDateCreated) {
		this.libDateCreated = libDateCreated;
	}

	public String getLibName() {
		return this.libName;
	}

	public void setLibName(String libName) {
		this.libName = libName;
	}

	@JsonManagedReference(value="library-shelf")
	public List<Shelf> getShelfs() {
		return this.shelfs;
	}

	public void setShelfs(List<Shelf> shelfs) {
		this.shelfs = shelfs;
	}

	public Shelf addShelf(Shelf shelf) {
		getShelfs().add(shelf);
		shelf.setLibrary(this);

		return shelf;
	}

	public Shelf removeShelf(Shelf shelf) {
		getShelfs().remove(shelf);
		shelf.setLibrary(null);

		return shelf;
	}
	

}
	