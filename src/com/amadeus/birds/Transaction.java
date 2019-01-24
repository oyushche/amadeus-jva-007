package com.amadeus.birds;

public class Transaction {
    private String client;
    private String birdName;
    private double price;
    private int count;

    public Transaction(String client, String birdName, double price, int count) {
        this.client = client;
        this.birdName = birdName;
        this.price = price;
        this.count = count;
    }

    public String getClient() {
        return this.client;
    }

    public String getBirdName() {
        return this.birdName;
    }

    public double getPrice() {
        return this.price;
    }

    public int getCount() {
        return this.count;
    }

    public double getTotal() {
        return this.price * this.count;
    }
}
