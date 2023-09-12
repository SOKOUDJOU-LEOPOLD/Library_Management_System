package com.example.library.controller;

import com.example.library.DTO.LibraryDTO;
import com.example.library.DTO.ShelfDTO;
import com.example.library.entity.Library;
import com.example.library.entity.Shelf;
import com.example.library.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ShelfRestController {

    @Autowired
    private ShelfService shelfService;

    // Get the list of shelfs
    @GetMapping("/shelfs")
    public ResponseEntity<List<ShelfDTO>> getShelfs(){

        return new ResponseEntity<>(shelfService.getshelfs(), HttpStatus.OK);
    }

    // Add a new Shelf
    @PostMapping("/shelfs")
    public ResponseEntity<Shelf> addShelf(@RequestBody Shelf shelf){

        return new ResponseEntity<>(shelfService.addShelf(shelf), HttpStatus.OK);

    }

    @GetMapping("/shelfs/{id}")
    public  ResponseEntity<ShelfDTO> getLibraryById(@PathVariable int id){
        Optional<ShelfDTO> shelfContainer = shelfService.findDTOById(id);
        if(shelfContainer.isPresent()){
            return new ResponseEntity<>(shelfContainer.get(),HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //update a shelf
    @PutMapping("/shelfs/{id}")
    public ResponseEntity<String> updateShelfById(@PathVariable int id, @RequestBody Shelf shelf){

        Optional<Shelf> existShelf = shelfService.findById(id);

        if(existShelf.isPresent()){
            Shelf newShelf = existShelf.get();
            newShelf.setShelfCode(shelf.getShelfCode());
            newShelf.setDomain(shelf.getDomain());
            newShelf.setLibrary(shelf.getLibrary());
            shelfService.updateShelf(newShelf);
            return new ResponseEntity<>("Library Details with id = "+id+" updated SUCCESSFULLY !!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Library Details with id = "+id+" Does not Exist   xxx :(", HttpStatus.OK);
        }

    }

    //delete shelf by code
    @DeleteMapping("/shelfs/{id}")
    public ResponseEntity<String> deleteShelfById(@PathVariable int id){

        shelfService.deleteById(id);

        return new ResponseEntity<>("Shelf deleted Successfully !!", HttpStatus.OK);

    }









}
