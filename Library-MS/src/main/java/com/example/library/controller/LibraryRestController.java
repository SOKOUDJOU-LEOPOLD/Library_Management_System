package com.example.library.controller;


import com.example.library.DTO.LibraryDTO;
import com.example.library.entity.Library;
import com.example.library.repository.LibraryRepository;
import com.example.library.service.LibraryService;
import com.example.library.serviceImpl.LibraryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LibraryRestController {
    @Autowired
    private LibraryService libraryService;

    //Get The list of all different Libraries present
    @GetMapping("/libraries")
    public ResponseEntity<List<LibraryDTO>> getLibraries(){

        return new ResponseEntity<>(libraryService.getLibraries(), HttpStatus.OK);
    }



    @PostMapping("/libraries")
    public ResponseEntity<LibraryDTO> addLibrary(@RequestBody Library library){

        return new ResponseEntity<>(libraryService.addLibrary(library), HttpStatus.OK);

    }



    // Get a Library from its id
    @GetMapping("/libraries/{id}")
    public  ResponseEntity<LibraryDTO> getLibraryById(@PathVariable int id){
        Optional<LibraryDTO> libraryContainer = libraryService.findDTOById(id);
        if(libraryContainer.isPresent()){
            return new ResponseEntity<>(libraryContainer.get(),HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get a Library from its Code
    @GetMapping("/libraries/lib/{libCode}")
    public  ResponseEntity<LibraryDTO> getLibraryByLibCode(@PathVariable String libCode){
        Optional<LibraryDTO> libraryContainer = libraryService.findByLibCode(libCode);
        if(libraryContainer.isPresent()){
            return new ResponseEntity<>(libraryContainer.get(),HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Update a Library Info
    @PutMapping("/libraries/{id}")
    public ResponseEntity<String> updateLibraryById(@PathVariable int id, @RequestBody Library library){

        Optional<Library> existlibrary = libraryService.findById(id);

        if(existlibrary.isPresent()){
            Library newlibrary = existlibrary.get();
            newlibrary.setLibCode(library.getLibCode());
            newlibrary.setLibName(library.getLibName());
            newlibrary.setLibDateCreated(library.getLibDateCreated());
            libraryService.updateLibrary(newlibrary);
            return new ResponseEntity<>("Library Details with id = "+id+" updated SUCCESSFULLY !!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Library Details with id = "+id+" Does not Exist   xxx :(", HttpStatus.OK);
        }
    }

    //deleting a library By Id

    @DeleteMapping("/libraries/{id}")
    public ResponseEntity<String> deleteLibraryById(@PathVariable int id){

        libraryService.deleteById(id);

        return new ResponseEntity<>("Library deleted Successfully !!", HttpStatus.OK);

    }

    //deleting a library By Code
    @DeleteMapping("/libraries/lib/{libCode}")
    public ResponseEntity<String> deleteLibraryByLibCode(@PathVariable String libCode){
        int flag = libraryService.deleteByLibCode(libCode);
        if(flag == 1)
            return new ResponseEntity<>("Library deleted Successfully !!", HttpStatus.OK);
        else
            return new ResponseEntity<>("Library NOT Present !!", HttpStatus.OK);
    }










}
