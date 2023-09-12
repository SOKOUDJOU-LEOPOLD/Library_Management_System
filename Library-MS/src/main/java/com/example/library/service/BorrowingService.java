package com.example.library.service;

import com.example.library.DTO.BorrowingDTO;
import com.example.library.entity.Borrowing;

import java.util.List;
import java.util.Optional;

public interface BorrowingService {

    Optional<Borrowing> findById(int id);

    List<BorrowingDTO> getListBorrowings();

    BorrowingDTO borrowItem(Borrowing borrowing);

    void updateBorrowing(Borrowing newBorrowing);

    List<BorrowingDTO> searchSubscriberBorrowingsNotReturned(int subId);

    List<BorrowingDTO> searchBorrowingsNotReturned();
}
