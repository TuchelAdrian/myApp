package com.ecenta.data;

import com.google.gson.annotations.Expose;

public class CartData {
    @Expose
    int id;
    @Expose
    int count;
    @Expose
    String totalAmount;

    public CartData(){};

    public CartData(int id, int count, String totalAmount) {
        this.id = id;
        this.count = count;
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
