package com.example.library.DTO;

public class FeeDTO {
    private int fee;

    public FeeDTO(){}

    public FeeDTO(int fee) {
        this.fee=fee;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}
