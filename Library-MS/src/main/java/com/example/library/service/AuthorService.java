package com.example.library.service;

import com.example.library.DTO.AuthorDTO;
import com.example.library.DTO.ItemDTO;
import com.example.library.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<AuthorDTO> getAuthors();

    List<ItemDTO> getItemsOfAuthorsByID(int id);

    Optional<Author> findById(int id);

    void updateAuthor(Author newAuthor);

    void deleteById(int id);
}
