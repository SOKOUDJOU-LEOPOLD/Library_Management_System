package com.example.library.DTO;

import java.util.Date;

public class BorrowingDTO {

    private int borrowId;

    private int itemId;

    private String itemName;
    private int subId;

    private Date borDate;

    private Date returnedDate;

    private Date actualDateReturned;

    private int fee;

    private String username;

    private String returned;


    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public String getReturned() {
        return returned;
    }

    public void setReturned(String returned) {
        this.returned = returned;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String status;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public Date getBorDate() {
        return borDate;
    }

    public void setBorDate(Date borDate) {
        this.borDate = borDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public Date getActualDateReturned() {
        return actualDateReturned;
    }

    public void setActualDateReturned(Date actualDateReturned) {
        this.actualDateReturned = actualDateReturned;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
