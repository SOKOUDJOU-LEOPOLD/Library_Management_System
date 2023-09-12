package com.example.library.service;

import com.example.library.DTO.LibraryDTO;
import com.example.library.DTO.ShelfDTO;
import com.example.library.entity.Shelf;

import java.util.List;
import java.util.Optional;

public interface ShelfService {
    List<ShelfDTO> getshelfs();

    Optional<ShelfDTO> findDTOById(int id);

    Shelf addShelf(Shelf shelf);

    Optional<Shelf> findById(int id);

    void updateShelf(Shelf newShelf);

    void deleteById(int id);
}
