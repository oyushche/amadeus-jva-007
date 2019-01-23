package com.amadeus.birds;

import java.util.UUID;

public class Bird implements IBird {

    public Bird(String type, double price) {
        this.type = type;
        this.price = price;
        this.uuid = UUID.randomUUID().toString();
    }

    private String uuid;


    public String getUuid() {
        return uuid;
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
