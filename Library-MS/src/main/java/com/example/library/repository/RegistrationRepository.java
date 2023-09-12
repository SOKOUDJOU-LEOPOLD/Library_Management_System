package com.example.library.repository;

import com.example.library.entity.Library;
import com.example.library.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {


}
