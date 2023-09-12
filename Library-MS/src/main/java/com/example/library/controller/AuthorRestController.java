package com.example.library.controller;

import com.example.library.DTO.AuthorDTO;
import com.example.library.DTO.ItemDTO;
import com.example.library.DTO.LibraryDTO;
import com.example.library.entity.Author;
import com.example.library.entity.Library;
import com.example.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthorRestController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public ResponseEntity<List<AuthorDTO>> getAuthors(){

        return new ResponseEntity<>(authorService.getAuthors(), HttpStatus.OK);
    }

    @GetMapping("/authors/{id}/items")
    public ResponseEntity<List<ItemDTO>>  getItemsOfAuthorsByID(@PathVariable int id){

        return new ResponseEntity<>(authorService.getItemsOfAuthorsByID(id), HttpStatus.OK);
    }

    //post method is not needed because we assume that an author is added when item is added.


    // put
    @PutMapping("/authors/{id}")
    public ResponseEntity<String> updateAuthorInfo(@PathVariable int id, @RequestBody Author author){

        Optional<Author> existAuthor = authorService.findById(id);

        if(existAuthor.isPresent()){
            Author newAuthor = existAuthor.get();
            newAuthor.setAuthorName(author.getAuthorName());
            newAuthor.setAuthEmail(author.getAuthEmail());
            newAuthor.setAuthField(author.getAuthField());

            authorService.updateAuthor(newAuthor);
            return new ResponseEntity<>("Author Details with id = "+id+" updated SUCCESSFULLY !!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Author Details with id = "+id+" Does not Exist   xxx :(", HttpStatus.OK);
        }
    }



    // delete
    @DeleteMapping("/authors/{id}")
    public ResponseEntity<String> deleteAuthorById(@PathVariable int id) {

        authorService.deleteById(id);

        return new ResponseEntity<>("Author deleted Successfully !!", HttpStatus.OK);


    }

}
