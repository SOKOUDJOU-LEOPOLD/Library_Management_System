package com.example.library.service;

import com.example.library.DTO.DomainDTO;
import com.example.library.DTO.LibraryDTO;
import com.example.library.entity.Domain;

import java.util.List;
import java.util.Optional;

public interface DomainService {

    public List<DomainDTO> getDomains();


    Domain addDomain(Domain domain);

    Optional<DomainDTO> findDTOById(int id);

    Optional<Domain> findById(int id);

    Optional<DomainDTO> findByDomCode(String domCode);

    void updateDomain(Domain newDomain);

    void deleteById(int id);

    int deleteByDomCode(String domCode);
}
