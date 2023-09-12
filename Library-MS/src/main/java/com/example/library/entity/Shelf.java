package com.example.library.entity;

//import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;


@Entity
@Table(name="shelf")
public class Shelf {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SHELF_ID")
	private int id;

	@Column(name="SHELF_CODE", unique=true, nullable=false, length=20)
	private String shelfCode;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="shelf",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Item> items;

	//bi-directional many-to-one association to Library
	@ManyToOne
	@JoinColumn(name="LIB_ID", nullable=false)
	private Library library;

	//bi-directional many-to-one association to Domain
	@ManyToOne
	@JoinColumn(name="DOM_ID", nullable=false)
	private Domain domain;

	public Shelf() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShelfCode() {
		return shelfCode;
	}

	public void setShelfCode(String shelfCode) {
		this.shelfCode = shelfCode;
	}

	@JsonManagedReference(value="shelf-item")
	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setShelf(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setShelf(null);

		return item;
	}

	@JsonBackReference(value="library-shelf")
	public Library getLibrary() {
		return this.library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	@JsonBackReference(value="domain-shelf")
	public Domain getDomain() {
		return this.domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	
}
