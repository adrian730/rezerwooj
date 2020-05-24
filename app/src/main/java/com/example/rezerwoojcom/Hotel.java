package com.example.rezerwoojcom;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Hotel {
    String name = "heron";
    String quantity = "siedem 7";
    String floor = "2";
    String image="link";
    String city="";
    Integer price = 100;
    boolean isFree = true;
    LocalDate date = LocalDate.now();
    LocalDate dateFrom = LocalDate.now();
    LocalDate dateTo = LocalDate.now();




    public Hotel() {
    }

    public Hotel(String name, String quantity, String floor, String image, String city, Integer price, boolean isFree, LocalDate date, LocalDate dateFrom, LocalDate dateTo) {
        this.name = name;
        this.quantity = quantity;
        this.floor = floor;
        this.image = image;
        this.city = city;
        this.price = price;
        this.isFree = isFree;
        this.date = date;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
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

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }
}
