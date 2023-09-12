package com.example.library.DTO;

import com.example.library.entity.Author;

import java.util.Date;
import java.util.List;

public class ItemDTO {
    private int id;
    private String name;
    private int copies;
    private String publisher;
    private Date published_year;
    private String category;
    private String shelf_name;


    private List<Author> authors;



    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublished_year() {
        return published_year;
    }

    public void setPublished_year(Date published_year) {
        this.published_year = published_year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getShelf_name() {
        return shelf_name;
    }

    public void setShelf_name(String shelf_name) {
        this.shelf_name = shelf_name;
    }
}
