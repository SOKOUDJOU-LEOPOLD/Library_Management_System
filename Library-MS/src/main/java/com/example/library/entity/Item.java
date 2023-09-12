package com.example.library.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="item")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ITEM_ID", unique=true, nullable=false)
	private int itemId;

	@Lob
	@Column(name="IMAGE")
	private byte[] image;

	@Column(name="ITEM_CATEGORY", length=20)
	private String itemCategory;

	@Column(name="ITEM_NAME", nullable=false, length=255)
	private String itemName;

	@Temporal(TemporalType.DATE)
	@Column(name="ITEM_PUB_YEAR")
	private Date itemPubYear;

	@Column(name="ITEM_PUBLISHER", nullable=false, length=255)
	private String itemPublisher;

	@Column(name="ITEM_QTITY", nullable=false)
	private int itemQtity;

	//bi-directional many-to-one association to Borrowing
	@OneToMany(mappedBy="item",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Borrowing> borrowings;

	//bi-directional many-to-one association to Shelf
	@ManyToOne
	@JoinColumn(name="SHELF_ID", nullable=false)
	private Shelf shelf;

	//bi-directional many-to-many association to Author
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
		name="item_author"
		, joinColumns={
			@JoinColumn(name="ITEM_ID", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="AUTHOR_ID", nullable=false)
			}
		)
	private List<Author> authors;

	public Item() {
	}

	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getItemCategory() {
		return this.itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Date getItemPubYear() {
		return this.itemPubYear;
	}

	public void setItemPubYear(Date itemPubYear) {
		this.itemPubYear = itemPubYear;
	}

	public String getItemPublisher() {
		return this.itemPublisher;
	}

	public void setItemPublisher(String itemPublisher) {
		this.itemPublisher = itemPublisher;
	}

	public int getItemQtity() {
		return this.itemQtity;
	}

	public void setItemQtity(int itemQtity) {
		this.itemQtity = itemQtity;
	}

	@JsonManagedReference(value = "item-borrowing")
	public List<Borrowing> getBorrowings() {
		return this.borrowings;
	}

	public void setBorrowings(List<Borrowing> borrowings) {
		this.borrowings = borrowings;
	}

	public Borrowing addBorrowing(Borrowing borrowing) {
		getBorrowings().add(borrowing);
		borrowing.setItem(this);

		return borrowing;
	}

	public Borrowing removeBorrowing(Borrowing borrowing) {
		getBorrowings().remove(borrowing);
		borrowing.setItem(null);

		return borrowing;
	}

	@JsonBackReference (value="shelf-item")
	public Shelf getShelf() {
		return this.shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

	public List<Author> getAuthors() {
		return this.authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}


}
