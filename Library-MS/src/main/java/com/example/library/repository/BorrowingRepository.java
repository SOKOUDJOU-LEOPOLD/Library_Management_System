package com.example.library.repository;

import com.example.library.entity.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BorrowingRepository extends JpaRepository<Borrowing, Integer> {

    @Query("SELECT b FROM Borrowing b WHERE b.subscriber.subNo = :id AND b.returned='NO' ")
    List<Borrowing> searchSubscriberBorrowingsNotReturned(@Param("id") int id);

    @Query("SELECT b FROM Borrowing b WHERE b.returned='NO' ")
    List<Borrowing> searchBorrowingsNotReturned();
}
