package com.example.library.entity;

//import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;


@Entity
@Table(name="author")
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AUTHOR_ID", unique=true, nullable=false)
	private int authorId;

	@Column(name="AUTH_EMAIL", nullable=false, length=255)
	private String authEmail;

	@Column(name="AUTH_FIELD", nullable=false, length=255)
	private String authField;

	@Column(name="AUTHOR_NAME", nullable=false, length=255)
	private String authorName;

	//bi-directional many-to-many association to Item

	@JsonIgnore    //to break the infinite recursion in a Many to Many relation
	@ManyToMany(mappedBy="authors")
	private List<Item> items;

	public Author() {
	}

	public int getAuthorId() {
		return this.authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthEmail() {
		return this.authEmail;
	}

	public void setAuthEmail(String authEmail) {
		this.authEmail = authEmail;
	}

	public String getAuthField() {
		return this.authField;
	}

	public void setAuthField(String authField) {
		this.authField = authField;
	}

	public String getAuthorName() {
		return this.authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
