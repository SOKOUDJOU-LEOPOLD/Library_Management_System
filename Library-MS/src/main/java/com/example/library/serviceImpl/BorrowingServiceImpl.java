package com.example.library.serviceImpl;

import com.example.library.DTO.BorrowingDTO;
import com.example.library.entity.Borrowing;
import com.example.library.entity.Item;
import com.example.library.entity.Subscriber;
import com.example.library.repository.BorrowingRepository;
import com.example.library.repository.ItemRepository;
import com.example.library.repository.SubscriberRepository;
import com.example.library.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BorrowingServiceImpl implements BorrowingService {

    @Autowired
    private BorrowingRepository borrowingRepository;

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Optional<Borrowing> findById(int id) {
        Optional<Borrowing> borrowingContainer = borrowingRepository.findById(id);
        return borrowingContainer;
    }

    @Override
    public List<BorrowingDTO> getListBorrowings() {
        List<Borrowing> borrowings=borrowingRepository.findAll();
        List<BorrowingDTO> borrowingDTOS=borrowings.stream().map(b->mapTODTO(b)).collect(Collectors.toList());

        return borrowingDTOS;
    }

    @Override
    public BorrowingDTO borrowItem(Borrowing borrowing) {

        //get the subscriber to obtain his type
        Optional<Subscriber> subscriber = subscriberRepository.findById(borrowing.getSubscriber().getSubNo());


        //Producing the returned date

        java.util.Date utilDate = new Date();
        java.sql.Date sqlDateAfter3Weeks = new java.sql.Date(utilDate.getTime() + (long)1.814e+9 );
        java.sql.Date sqlDateAfter5Weeks = new java.sql.Date(utilDate.getTime() + (long)3.024e+9 );


        //Depending on the type of the subscriber, you set the returned date ****** Fancy logic for borrowing a book

        borrowing.setBorDate(new java.sql.Date(utilDate.getTime())); //converting util.Date -> sql.Date
        //printing the subscriber type
        System.out.println(subscriber.get().getSubType());
        if(subscriber.isPresent()){
            if(subscriber.get().getSubType().equals("REGULAR")){

                borrowing.setReturnedDate(sqlDateAfter3Weeks);
            } else if (subscriber.get().getSubType().equals("GOLDEN")) {

                borrowing.setReturnedDate(sqlDateAfter5Weeks);
            }

        }

        //update the item qtity in item table after borrowing
        Optional<Item> itemContainer = itemRepository.findById(borrowing.getItem().getItemId());
        if(itemContainer.isPresent()){
            Item item = itemContainer.get();
            item.setItemQtity(item.getItemQtity()-1);
            itemRepository.save(item);

        }
        borrowing.setFee(0);
        borrowing.setStatus("NO FEE");
        borrowing.setReturned("NO");
        Borrowing borrowing1=borrowingRepository.save(borrowing);
        BorrowingDTO borrowingDTO = mapTODTO(borrowing1);
        return borrowingDTO;
    }

    @Override
    public void updateBorrowing(Borrowing newBorrowing) {

        borrowingRepository.save(newBorrowing);

        //update the item qtity in item table after returning
        Optional<Item> itemContainer = itemRepository.findById(newBorrowing.getItem().getItemId());
        if(itemContainer.isPresent()){
            Item item = itemContainer.get();
            item.setItemQtity(item.getItemQtity()+1);
            itemRepository.save(item);

        }

    }

    @Override
    public List<BorrowingDTO> searchSubscriberBorrowingsNotReturned(int subId) {
        List<Borrowing> borrowings = borrowingRepository.searchSubscriberBorrowingsNotReturned(subId);
        List<BorrowingDTO> borrowingDTOS=borrowings.stream().map(b->mapTODTO(b)).collect(Collectors.toList());

        return borrowingDTOS;
    }

    @Override
    public List<BorrowingDTO> searchBorrowingsNotReturned() {
        List<Borrowing> borrowings = borrowingRepository.searchBorrowingsNotReturned();
        List<BorrowingDTO> borrowingDTOS=borrowings.stream().map(b->mapTODTO(b)).collect(Collectors.toList());

        return borrowingDTOS;
    }

    private BorrowingDTO mapTODTO(Borrowing b) {
        BorrowingDTO borrowingDTO = new BorrowingDTO();

        borrowingDTO.setItemId(b.getItem().getItemId());
        borrowingDTO.setItemName(b.getItem().getItemName());
        borrowingDTO.setBorDate(b.getBorDate());
        borrowingDTO.setReturnedDate(b.getReturnedDate());
        borrowingDTO.setActualDateReturned(b.getDateActualReturned());
        borrowingDTO.setFee(b.getFee());
        borrowingDTO.setStatus(b.getStatus());
        borrowingDTO.setSubId(b.getSubscriber().getSubNo());
        borrowingDTO.setUsername(b.getSubscriber().getSubUsername());
        borrowingDTO.setReturned(b.getReturned());
        borrowingDTO.setBorrowId(b.getBorId());

        return borrowingDTO;
    }


}
