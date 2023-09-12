package com.example.library.serviceImpl;

import com.example.library.DTO.ShelfDTO;
import com.example.library.entity.Library;
import com.example.library.entity.Shelf;
import com.example.library.repository.ShelfRepository;
import com.example.library.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShelfServiceImpl implements ShelfService {

    @Autowired
    private ShelfRepository shelfRepository;

    @Override
    public List<ShelfDTO> getshelfs() {
        List<Shelf> shelfS = shelfRepository.findAll();
        List<ShelfDTO> shelfDTOS = shelfS.stream().map(s->mapToDTO(s)).collect(Collectors.toList());

        return  shelfDTOS;
    }

    @Override
    public Optional<ShelfDTO> findDTOById(int id) {
        Optional<Shelf> shelf  = shelfRepository.findById(id);

        return Optional.of(mapToDTO(shelf.get()));
    }

    private ShelfDTO mapToDTO(Shelf s) {
        ShelfDTO shelfDTO = new ShelfDTO();
        shelfDTO.setId(s.getId());
        shelfDTO.setShelfCode(s.getShelfCode());
        shelfDTO.setLbId(s.getLibrary().getId());
        shelfDTO.setDomId(s.getDomain().getId());

        return shelfDTO;
    }

    @Override
    public Shelf addShelf(Shelf shelf) {
        return shelfRepository.save(shelf);
    }

    @Override
    public Optional<Shelf> findById(int id) {
        Optional<Shelf> shelfContainer = shelfRepository.findById(id);
        return shelfContainer;
    }

    @Override
    public void updateShelf(Shelf newShelf) {
        shelfRepository.save(newShelf);
    }

    @Override
    public void deleteById(int id) {
        shelfRepository.deleteById(id);
    }


}
