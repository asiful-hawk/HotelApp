package com.example.hotelapp.Model;

import java.util.Date;

public class HotelLog {
    int id;
    String hotelName;
    int roomId;
    int customerId;
    double paymentForHotel;
    Date reserveFrom;
    Date reserveTill;
    Double paymentForAdmin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getPaymentForHotel() {
        return paymentForHotel;
    }

    public void setPaymentForHotel(double paymentForHotel) {
        this.paymentForHotel = paymentForHotel;
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

    public Double getPaymentForAdmin() {
        return paymentForAdmin;
    }

    public void setPaymentForAdmin(Double paymentForAdmin) {
        this.paymentForAdmin = paymentForAdmin;
    }
}
