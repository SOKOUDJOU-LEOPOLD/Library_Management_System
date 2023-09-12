package com.example.library.repository;

import com.example.library.entity.Domain;
import com.example.library.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DomainRepository extends JpaRepository<Domain, Integer> {


    @Query("SELECT d FROM Domain d WHERE d.domCode= :domCode ")
    Optional<Domain> findByDomCode(@Param("domCode") String domCode);
}
