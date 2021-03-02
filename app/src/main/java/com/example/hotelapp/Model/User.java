package com.example.hotelapp.Model;

import java.util.Date;

public class User {
    int id;
    String name;
    String mobile;
    String email;
    String password;
    String type;
    int roomId;
    Date reserveFrom;
    Date reserveTill;
    double payment;
    String payInfo;
    String nid;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Date getReserveFrom() {
        return reserveFrom;
    }

    public void setReserveFrom(Date reserveFrom) {
        this.reserveFrom = reserveFrom;
    }

    public Date getReserveTill() {
        return reserveTill;
    }

    public void setReserveTill(Date reserveTill) {
        this.reserveTill = reserveTill;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getPayInfo() {
        return payInfo;
    }

    public void setPayInfo(String payInfo) {
        this.payInfo = payInfo;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }
}
