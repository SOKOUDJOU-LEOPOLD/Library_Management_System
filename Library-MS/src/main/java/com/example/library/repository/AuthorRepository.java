package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.Domain;
import com.example.library.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
