package com.example.library.controller;

import com.example.library.DTO.BorrowingDTO;
import com.example.library.DTO.FeeDTO;
import com.example.library.entity.Borrowing;

import com.example.library.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BorrowingRestController {

    @Autowired
    private BorrowingService borrowingService;

    //Get a list of Borrowing
    @GetMapping("/borrows")
    public ResponseEntity<List<BorrowingDTO>> getListBorrowings(){

        return new ResponseEntity<>(borrowingService.getListBorrowings(), HttpStatus.OK);
    }

    //Borrow a book  ***************************************
    @PostMapping("/borrows")
    public ResponseEntity<BorrowingDTO> borrowItem(@RequestBody Borrowing borrowing){

        return new ResponseEntity<>(borrowingService.borrowItem(borrowing),HttpStatus.OK);
    }

    //Update a borrow


    //return an Item
    @PutMapping("/borrows/return/{id}")
    public ResponseEntity<String> returnItem(@PathVariable int id){
        Optional<Borrowing> existBorrowing = borrowingService.findById(id);

        if(existBorrowing.isPresent()){
            if(existBorrowing.get().getReturned().equals("NO")) {
                //getting current date
                java.util.Date utilDateNOW = new Date();

                Borrowing newBorrowing = existBorrowing.get();

                long diff = (utilDateNOW.getTime() - newBorrowing.getReturnedDate().getTime()) / ((1000 * 60 * 60 * 24));

                int fee;

                if (diff > 0) {
                    fee = (int) (1000 * diff); // fee to pay
                    newBorrowing.setStatus("PAID");
                } else {
                    fee = 0;
                    newBorrowing.setStatus("NO FEE");
                }

                newBorrowing.setFee(fee);
                newBorrowing.setDateActualReturned(new java.sql.Date(utilDateNOW.getTime()));
                newBorrowing.setReturned("YES");

                borrowingService.updateBorrowing(newBorrowing);

                return new ResponseEntity<>("Item returned SUCCESSFULLY !!", HttpStatus.OK);
            }
            else
                return new ResponseEntity<>("Item was already returned !!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("This Borrowing Does not Exist  xxx :(", HttpStatus.OK);
        }


    }


    //check the fee for a borrowing
    @GetMapping("/borrows/{id}/fee")
    public ResponseEntity<FeeDTO> checkFee(@PathVariable int id){
        Optional<Borrowing> existBorrowing = borrowingService.findById(id);
        if(existBorrowing.isPresent()){
            java.util.Date utilDateNOW = new Date();

            Borrowing newBorrowing = existBorrowing.get();

            long diff = (utilDateNOW.getTime()-newBorrowing.getReturnedDate().getTime())/((1000 * 60 * 60 * 24));

            int fee;

            if(diff>0){
                fee = (int)(1000*diff); // fee to pay
            }else{
                fee= 0;
            }

            return new ResponseEntity<>(new FeeDTO(fee) , HttpStatus.OK);
        }

        return new ResponseEntity<>(new FeeDTO(0) , HttpStatus.OK);

    }

    //delete a borrow
    // I prefer not to delete the Borrowing. it can serve as history


//     Searching

    //searching for user's borrowings not yet returned
    @GetMapping("/subscribers/{subId}/borrows")
    public ResponseEntity<List<BorrowingDTO>> searchSubscriberBorrowingsNotReturned(@PathVariable int subId){

        return new ResponseEntity<>(borrowingService.searchSubscriberBorrowingsNotReturned(subId), HttpStatus.OK);
    }

    //searching for all borrowing not returned
    @GetMapping("/borrows/not-returned")
    public ResponseEntity<List<BorrowingDTO>> searchBorrowingsNotReturned(){

        return new ResponseEntity<>(borrowingService.searchBorrowingsNotReturned(), HttpStatus.OK);
    }
}
