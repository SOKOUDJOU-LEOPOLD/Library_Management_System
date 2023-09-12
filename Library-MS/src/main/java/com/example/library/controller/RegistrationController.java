package com.example.library.controller;


import com.example.library.entity.Library;
import com.example.library.entity.Registration;
import com.example.library.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/registrations")
    public ResponseEntity<List<Registration>> getRegistrations(){

        return new ResponseEntity<>(registrationService.getRegistrations(), HttpStatus.OK);
    }


}
