package com.example.library.serviceImpl;

import com.example.library.entity.Registration;
import com.example.library.repository.RegistrationRepository;
import com.example.library.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public List<Registration> getRegistrations() {
        return registrationRepository.findAll();
    }
}
