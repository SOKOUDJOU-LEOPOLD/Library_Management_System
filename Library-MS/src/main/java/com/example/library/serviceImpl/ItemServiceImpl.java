package com.example.library.serviceImpl;

import com.example.library.DTO.ItemDTO;
import com.example.library.DTO.LibraryDTO;
import com.example.library.entity.Item;
import com.example.library.entity.Library;
import com.example.library.repository.ItemRepository;
import com.example.library.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Override
    public List<ItemDTO> getItems() {
        List<Item> items = itemRepository.findAll();

        List<ItemDTO> itemDTOS = items.stream().map(i -> mapToDto(i)).collect(Collectors.toList());

        return itemDTOS;
    }

    @Override
    public ItemDTO addItem(Item item) {
        return mapToDto(itemRepository.save(item));
    }

    @Override
    public Optional<ItemDTO> findDTOById(int id) {
        Optional<Item> item  = itemRepository.findById(id);

        return Optional.of(mapToDto(item.get()));
    }

    @Override
    public Optional<Item> findById(int id) {

        return itemRepository.findById(id);
    }

    @Override
    public void updateLibrary(Item newItem) {
        itemRepository.save(newItem);
    }

    @Override
    public void deleteById(int id) {
        itemRepository.deleteById(id);
    }

    private ItemDTO mapToDto(Item i) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(i.getItemId());
        itemDTO.setName(i.getItemName());
        itemDTO.setCopies(i.getItemQtity());
        itemDTO.setPublisher(i.getItemPublisher());
        itemDTO.setPublished_year(i.getItemPubYear());
        itemDTO.setCategory(i.getItemCategory());
        itemDTO.setShelf_name(i.getShelf().getShelfCode());
        itemDTO.setAuthors(i.getAuthors());

        return itemDTO;

    }
}
