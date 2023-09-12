package com.example.library.controller;


import com.example.library.DTO.LibraryDTO;
import com.example.library.DTO.SubscriberDTO;
import com.example.library.entity.Library;
import com.example.library.entity.Subscriber;
import com.example.library.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SubscriberRestController {

    @Autowired
    private SubscriberService subscriberService;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/subscribers")
    public ResponseEntity<List<SubscriberDTO>> getSubscribers() {

        Optional<List<SubscriberDTO>> subscriberDTOS = Optional.of(subscriberService.getSubscribers());
        if (subscriberDTOS.isPresent()) {
            return new ResponseEntity<>(subscriberService.getSubscribers(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>( HttpStatus.OK);
        }
    }

    @PostMapping("/subscribers")
    public ResponseEntity<SubscriberDTO> addSubscriber(@RequestBody Subscriber subscriber){

        //encrypt Password
        subscriber.setSubPassword("{bcrypt}"+passwordEncoder.encode(subscriber.getSubPassword()));

        return new ResponseEntity<>(subscriberService.addSubscriber(subscriber), HttpStatus.OK);

    }

    @PutMapping("/subscribers/{id}")
    public ResponseEntity<String> updateSubscriberById(@PathVariable int id, @RequestBody Subscriber subscriber){

        Optional<Subscriber> existSubscriber = subscriberService.findById(id);

        if(existSubscriber.isPresent()){
            Subscriber newSubscriber = existSubscriber.get();
            newSubscriber.setSubFname(subscriber.getSubFname());
            newSubscriber.setSubLname(subscriber.getSubLname());
            newSubscriber.setSubUsername(subscriber.getSubUsername());
            newSubscriber.setSubEmail(subscriber.getSubEmail());
            newSubscriber.setSubType(subscriber.getSubType());

            newSubscriber.setSubPassword("{bcrypt}"+passwordEncoder.encode(subscriber.getSubPassword()));

            subscriberService.updateSubscriber(newSubscriber);
            return new ResponseEntity<>("Subscriber Details with id = "+id+" updated SUCCESSFULLY !!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Subscriber Details with id = "+id+" Does not Exist   xxx :(", HttpStatus.OK);
        }
    }

    @DeleteMapping("/subscribers/{id}")
    public ResponseEntity<String> deleteLibraryById(@PathVariable int id){

        subscriberService.deleteById(id);

        return new ResponseEntity<>("Subscriber deleted Successfully !!", HttpStatus.OK);

    }










}
