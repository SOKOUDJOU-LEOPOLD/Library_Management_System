package com.example.library.service;

import com.example.library.DTO.ItemDTO;
import com.example.library.entity.Item;
import com.example.library.entity.Library;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<ItemDTO> getItems();

    ItemDTO addItem(Item item);

    Optional<ItemDTO> findDTOById(int id);

    Optional<Item> findById(int id);

    void updateLibrary(Item newItem);

    void deleteById(int id);
}
