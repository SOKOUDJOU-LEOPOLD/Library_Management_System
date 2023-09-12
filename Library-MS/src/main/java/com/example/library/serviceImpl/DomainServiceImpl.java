package com.example.library.serviceImpl;

import com.example.library.DTO.DomainDTO;
import com.example.library.entity.Domain;
import com.example.library.entity.Library;
import com.example.library.repository.DomainRepository;
import com.example.library.repository.LibraryRepository;
import com.example.library.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DomainServiceImpl implements DomainService{

    @Autowired
    private DomainRepository domainRepository;

    @Override
    public List<DomainDTO> getDomains() {

        List<Domain> domains = domainRepository.findAll();

        List<DomainDTO> domainDTOS = domains.stream().map(d -> mapToDTO(d)).collect(Collectors.toList());

        return domainDTOS;
    }

    private DomainDTO mapToDTO(Domain d) {
        DomainDTO domainDTO = new DomainDTO();

        domainDTO.setId(d.getId());
        domainDTO.setCode(d.getDomCode());
        domainDTO.setName(d.getDomName());
        domainDTO.setDate_created(d.getDomDateCreated());

        return domainDTO;

    }

    @Override
    public Domain addDomain(Domain domain) {

        return domainRepository.save(domain);

    }

    @Override
    public Optional<DomainDTO> findDTOById(int id) {
        Optional<Domain> domain  = domainRepository.findById(id);

        return Optional.of(mapToDTO(domain.get()));
    }

    @Override
    public Optional<Domain> findById(int id) {
        return domainRepository.findById(id);
    }

    @Override
    public Optional<DomainDTO> findByDomCode(String domCode) {
        Optional<Domain> domain  = domainRepository.findByDomCode(domCode);
        return Optional.of(mapToDTO(domain.get()));
    }

    @Override
    public void updateDomain(Domain newdomain) {
        domainRepository.save(newdomain);
    }

    @Override
    public void deleteById(int id) {
        domainRepository.deleteById(id);
    }

    @Override
    public int deleteByDomCode(String domCode) {
        Optional<Domain> domain = domainRepository.findByDomCode(domCode);

        if(domain.isPresent()){
            domainRepository.deleteById(domain.get().getId());
            return 1;
        }
        return 0;
    }


}
