package com.bank.model;

import com.bank.util.IDGenerator;

public class User {
    private String name;
    private int MobileNo;
    private String address;
    private String email;
    private String userid;

    public User(String name, int mobileNo, String address, String email) {
        this.name = name;
        MobileNo = mobileNo;
        this.address = address;
        this.email = email;
        this.userid = new IDGenerator().GenerateuserID();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(int mobileNo) {
        MobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public String getUserid() {
        return userid;
    }

    public void setAddress(String address) {
        this.address = address;

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", MobileNo=" + MobileNo +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", userid=" + userid +
                '}';
    }
}
