package com.lazytomatostudios.t9dialer;

/**
 * Created by drpayyne on 20/1/18.
 */

public class Contact {

    private String name;
    private int phone;

    public Contact(){

    }

    public Contact(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
