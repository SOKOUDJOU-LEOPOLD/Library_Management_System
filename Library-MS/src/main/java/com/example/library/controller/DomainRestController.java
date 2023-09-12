package com.example.library.controller;

import com.example.library.DTO.DomainDTO;
import com.example.library.entity.Domain;
import com.example.library.entity.Library;
import com.example.library.service.DomainService;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DomainRestController {

    @Autowired
    private DomainService domainService;

    //Get The list of all different domains present
    @GetMapping("/domains")
    public ResponseEntity<List<DomainDTO>> getDomains(){

        return new ResponseEntity<>(domainService.getDomains(), HttpStatus.OK);
    }



    //Add a new domain to the database
    @PostMapping("/domains")
    public ResponseEntity<Domain> addDomain(@RequestBody Domain domain){

        return new ResponseEntity<>(domainService.addDomain(domain), HttpStatus.OK);

    }

    // Get a domain from its id
    @GetMapping("/domains/{id}")
    public  ResponseEntity<DomainDTO> getLibraryById(@PathVariable int id){
        Optional<DomainDTO> domainContainer = domainService.findDTOById(id);
        if(domainContainer.isPresent()){
            return new ResponseEntity<>(domainContainer.get(),HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get a domain from its Code
    @GetMapping("/domains/dom/{domCode}")
    public  ResponseEntity<DomainDTO> getDomainByDomCode(@PathVariable String domCode){
        Optional<DomainDTO> domainContainer = domainService.findByDomCode(domCode);
        if(domainContainer.isPresent()){
            return new ResponseEntity<>(domainContainer.get(),HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Update a domain Info
    @PutMapping("/domains/{id}")
    public ResponseEntity<String> updateLibraryById(@PathVariable int id, @RequestBody Domain domain){

        Optional<Domain> existdomain= domainService.findById(id);

        if(existdomain.isPresent()){
            Domain newdomain = existdomain.get();
            newdomain.setDomCode(domain.getDomCode());
            newdomain.setDomName(domain.getDomName());
            newdomain.setDomDateCreated(domain.getDomDateCreated());

            //optional line(s) to add shelf but not efficient
           // newdomain.setShelfs(domain.getShelfs());

            domainService.updateDomain(newdomain);
            return new ResponseEntity<>("Domain Details with id = "+id+" updated SUCCESSFULLY !!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Domain Details with id = "+id+" Does not Exist   xxx :(", HttpStatus.OK);
        }
    }

    //deleting a domain By Id

    @DeleteMapping("/domains/{id}")
    public ResponseEntity<String> deleteDomainById(@PathVariable int id){

        domainService.deleteById(id);

        return new ResponseEntity<>("Domain deleted Successfully !!", HttpStatus.OK);

    }

    //deleting a domain By Code
    @DeleteMapping("/domains/dom/{domCode}")
    public ResponseEntity<String> deleteDomainByDomCode(@PathVariable String domCode){
        int flag = domainService.deleteByDomCode(domCode);
        if(flag == 1)
            return new ResponseEntity<>("Doamain deleted Successfully !!", HttpStatus.OK);
        else
            return new ResponseEntity<>("Domain NOT Present !!", HttpStatus.OK);
    }




}
