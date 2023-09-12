package com.example.library.service;

import com.example.library.DTO.LibraryDTO;
import com.example.library.entity.Library;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface LibraryService {

    public List<LibraryDTO> getLibraries();


    LibraryDTO addLibrary(Library library);

    Optional<LibraryDTO> findDTOById(int id);

    Optional<Library> findById(int id);

    Optional<LibraryDTO> findByLibCode(String libCode);

    void updateLibrary(Library newlibrary);

    void deleteById(int id);

    int deleteByLibCode(String libCode);
}
