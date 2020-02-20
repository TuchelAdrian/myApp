package com.ecenta.data;

import com.google.gson.annotations.Expose;

public class UserData {
    @Expose
    private int id;
    @Expose
    private String name;
    @Expose
    private String password;
    @Expose
    private String phone;
    @Expose
    private String email;
    @Expose
    private String address;
    @Expose
    private CartData cartData;

    public UserData(){};
    public UserData(int id, String name, String password, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
    public UserData(int id, String name, String password, String phone, String email, String address, CartData cartData) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.cartData=cartData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CartData getCartData() {
        return cartData;
    }

    public void setCartData(CartData cartData) {
        this.cartData = cartData;
    }
}
