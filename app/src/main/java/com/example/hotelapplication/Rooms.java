package com.example.hotelapplication;

public class Rooms {
    private String name;
    private double price;
    private  String image1;
    private String image2;

    public Rooms(String name, double price, String image1, String image2) {
        this.name = name;
        this.price = price;
        this.image1 = image1;
        this.image2 = image2;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }
}
