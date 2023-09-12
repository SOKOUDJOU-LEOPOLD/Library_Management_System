package com.example.library.repository;

import com.example.library.entity.Domain;
import com.example.library.entity.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelfRepository extends JpaRepository<Shelf, Integer> {
}
