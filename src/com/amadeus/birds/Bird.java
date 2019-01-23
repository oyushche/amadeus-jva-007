package com.amadeus.birds;

public class Bird implements IBird {

    public Bird(String type, double price) {
        this.type = type;
        this.price = price;
    }


    private String type;

    public String getType() {
        return type;
    }


    private double price;

    public double getPrice() {
        return price;
    }
}
