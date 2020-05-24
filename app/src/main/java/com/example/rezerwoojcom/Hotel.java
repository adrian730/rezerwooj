package com.example.rezerwoojcom;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Hotel {
   private String name = "heron";
    private String quantity = "siedem 7";
    private String floor = "2";
    private String image="link";
    private String city="";
    private Integer price = 100;





    public Hotel() {
    }


    public Hotel(String name, String quantity, String floor, String image, String city, Integer price) {
        this.name = name;
        this.quantity = quantity;
        this.floor = floor;
        this.image = image;
        this.city = city;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
