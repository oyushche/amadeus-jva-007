package com.amadeus.birds;

public class Bird {
    private String name;
    private double price;

    public Bird(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}
