package com.example.hotelapp.Model;

public class Room {
    int roomId;
    String availability;
    double price;
    String cottageName;
    int customerId;
    String location;
    int capacity;
    String img;

    public Room(int roomId, String availability, double price, String cottageName, int customerId, String location, int capacity, String img) {
        this.roomId = roomId;
        this.availability = availability;
        this.price = price;
        this.cottageName = cottageName;
        this.customerId = customerId;
        this.location = location;
        this.capacity = capacity;
        this.img = img;
    }


    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCottageName() {
        return cottageName;
    }

    public void setCottageName(String cottageName) {
        this.cottageName = cottageName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
