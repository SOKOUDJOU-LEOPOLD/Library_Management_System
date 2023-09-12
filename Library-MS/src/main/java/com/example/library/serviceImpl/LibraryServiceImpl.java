package com.example.library.serviceImpl;

import com.example.library.DTO.LibraryDTO;
import com.example.library.entity.Library;
import com.example.library.repository.LibraryRepository;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;


    //Using DTO object
    @Override
    public List<LibraryDTO> getLibraries() {

        List<Library> libraries = libraryRepository.findAll();

        List<LibraryDTO> libraryDTOS = libraries.stream().map(l -> mapToDto(l)).collect(Collectors.toList());

        return libraryDTOS;

    }

    private LibraryDTO mapToDto(Library l) {

        LibraryDTO libraryDTO = new LibraryDTO();
        libraryDTO.setId(l.getId());
        libraryDTO.setCode(l.getLibCode());
        libraryDTO.setName(l.getLibName());
        libraryDTO.setDate_created(l.getLibDateCreated());

        return libraryDTO;
    }

    @Override
    public LibraryDTO addLibrary(Library library) {

        return mapToDto(libraryRepository.save(library));

    }

    @Override
    public Optional<LibraryDTO> findDTOById(int id) {
        Optional<Library> library  = libraryRepository.findById(id);

        return Optional.of(mapToDto(library.get()));
    }

    @Override
    public Optional<Library> findById(int id) {
        return libraryRepository.findById(id);
    }

    @Override
    public Optional<LibraryDTO> findByLibCode(String libCode) {
        Optional<Library> library  = libraryRepository.findByLibCode(libCode);
        return Optional.of(mapToDto(library.get()));
    }

    @Override
    public void updateLibrary(Library newlibrary) {
        libraryRepository.save(newlibrary);
    }

    @Override
    public void deleteById(int id) {
        libraryRepository.deleteById(id);
    }

    @Override
    public int deleteByLibCode(String libCode) {
        Optional<Library> library = libraryRepository.findByLibCode(libCode);

        if(library.isPresent()){
            libraryRepository.deleteById(library.get().getId());
            return 1;
        }
        return 0;
    }


}
