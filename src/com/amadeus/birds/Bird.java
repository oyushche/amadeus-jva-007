package com.amadeus.birds;

/**
 * Created by Kysliakovskyi on 24.01.2019.
 */
public class Bird {
    private String name;
    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Bird: " + name + '\'';
    }

    public Bird() {
    }

    public Bird(String name, Double price) {

        this.name = name;
        this.price = price;
    }

    public Bird(String name) {
        this.name = name;
        this.price = 0.0;

    }

    public void setName(String name) {
        this.name = name;
    }
}
