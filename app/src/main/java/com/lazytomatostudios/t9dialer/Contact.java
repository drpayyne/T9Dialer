package com.lazytomatostudios.t9dialer;

/**
 * Created by drpayyne on 20/1/18.
 */

public class Contact {

    private String name;
    private long phone;

    public Contact(){

    }

    public Contact(String name, long phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
