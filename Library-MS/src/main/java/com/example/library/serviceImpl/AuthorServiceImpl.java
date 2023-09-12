package com.example.library.serviceImpl;

import com.example.library.DTO.AuthorDTO;
import com.example.library.DTO.ItemDTO;
import com.example.library.entity.Author;
import com.example.library.entity.Item;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.ItemRepository;
import com.example.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<AuthorDTO> getAuthors() {
        List<Author> authors =authorRepository.findAll();
        List<AuthorDTO> authorDTOS=authors.stream().map(a->mapToDTO(a)).collect(Collectors.toList());
        return authorDTOS;
    }

    @Override
    public List<ItemDTO> getItemsOfAuthorsByID(int id) {
        Optional<Author> author = authorRepository.findById(id);
        List<Item> items = author.get().getItems();
        List<ItemDTO> itemDTOS= items.stream().map(a->mapToDto(a)).collect(Collectors.toList());
        return itemDTOS;
    }

    @Override
    public Optional<Author> findById(int id) {
        return authorRepository.findById(id);
    }

    @Override
    public void updateAuthor(Author newAuthor) {
        authorRepository.save(newAuthor);
    }

    @Override
    public void deleteById(int id) {
        authorRepository.deleteById(id);
    }

    private AuthorDTO mapToDTO(Author a) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(a.getAuthorId());
        authorDTO.setEmail(a.getAuthEmail());
        authorDTO.setName(a.getAuthorName());
        return authorDTO;
    }


    private ItemDTO mapToDto(Item i) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(i.getItemId());
        itemDTO.setName(i.getItemName());
        itemDTO.setCategory(i.getItemCategory());
        itemDTO.setShelf_name(i.getShelf().getShelfCode());
        itemDTO.setPublisher(i.getItemPublisher());
        itemDTO.setPublished_year(i.getItemPubYear());
        itemDTO.setCopies(i.getItemQtity());
        return itemDTO;

    }
}
