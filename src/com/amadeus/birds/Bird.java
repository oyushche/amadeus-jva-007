package com.amadeus.birds;

enum BirdType {
    EAGLE, DUCK, CROW
}

public class Bird {
    private BirdType type;
    private Float price;

    public Bird(BirdType type) {
        this.type = type;
    }

    public Bird(BirdType type, Float price)
    {
        this.type = type;
        this.price = price;
    }

    public BirdType getType() {
        return type;
    }

    public void setType(BirdType type) {
        this.type = type;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}