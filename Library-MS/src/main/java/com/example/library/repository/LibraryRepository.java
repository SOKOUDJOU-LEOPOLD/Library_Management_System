package com.example.library.repository;

import com.example.library.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LibraryRepository extends JpaRepository<Library, Integer> {

    @Query("SELECT l FROM Library l WHERE l.libCode= :libCode ")
    Optional<Library> findByLibCode(@Param("libCode") String libCode);
}
