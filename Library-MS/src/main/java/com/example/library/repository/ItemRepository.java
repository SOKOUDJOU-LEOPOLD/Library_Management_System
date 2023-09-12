package com.example.library.repository;

import com.example.library.entity.Item;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Integer> {

}
