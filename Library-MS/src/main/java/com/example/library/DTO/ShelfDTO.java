package com.example.library.DTO;

public class ShelfDTO {

    private int id;
    private String shelfCode;
    private int lbId;
    private int domId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShelfCode() {
        return shelfCode;
    }

    public void setShelfCode(String shelfCode) {
        this.shelfCode = shelfCode;
    }

    public int getLbId() {
        return lbId;
    }

    public void setLbId(int lbId) {
        this.lbId = lbId;
    }

    public int getDomId() {
        return domId;
    }

    public void setDomId(int domId) {
        this.domId = domId;
    }
}
