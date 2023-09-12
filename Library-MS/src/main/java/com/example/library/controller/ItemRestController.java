package com.example.library.controller;

import com.example.library.DTO.ItemDTO;
import com.example.library.DTO.LibraryDTO;
import com.example.library.entity.Item;
import com.example.library.entity.Library;
import com.example.library.entity.Shelf;
import com.example.library.service.ItemService;
import com.example.library.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ItemRestController {

    @Autowired
    private ItemService itemService;

    // Get the list of shelfs
    @GetMapping("/items")
    public ResponseEntity<List<ItemDTO>> getItems(){

        return new ResponseEntity<>(itemService.getItems(), HttpStatus.OK);
    }

    @PostMapping("/items")
    public ResponseEntity<ItemDTO> addItem(@RequestBody Item item){

        return new ResponseEntity<>(itemService.addItem(item), HttpStatus.OK);

    }

    // Get a item from its id
    @GetMapping("/items/{id}")
    public  ResponseEntity<ItemDTO> getItemById(@PathVariable int id){
        Optional<ItemDTO> itemContainer = itemService.findDTOById(id);
        if(itemContainer.isPresent()){
            return new ResponseEntity<>(itemContainer.get(),HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update an Item Info
    @PutMapping("/items/{id}")
    public ResponseEntity<String> updateItemById(@PathVariable int id, @RequestBody Item item){

        Optional<Item> existItem= itemService.findById(id);

        if(existItem.isPresent()){
            Item newItem = existItem.get();
            newItem.setItemCategory(item.getItemCategory());
            newItem.setShelf(item.getShelf());
            newItem.setItemPublisher(item.getItemPublisher());
            newItem.setItemQtity(item.getItemQtity());
            newItem.setItemName(item.getItemName());
            newItem.setImage(item.getImage());
            newItem.setShelf(item.getShelf());
            itemService.updateLibrary(newItem);
            return new ResponseEntity<>("Item Details with id = "+id+" updated SUCCESSFULLY !!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Item Details with id = "+id+" Does not Exist   xxx :(", HttpStatus.OK);
        }

    }


    @DeleteMapping("/items/{id}")
    public ResponseEntity<String> deleteLibraryById(@PathVariable int id){

        itemService.deleteById(id);

        return new ResponseEntity<>("Item deleted Successfully !!", HttpStatus.OK);

    }







}
